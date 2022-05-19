package com.mhacard.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.mhacard.model.CardPrintingList;
import com.mhacard.model.PersonResponse;
import com.mhacard.service.CardPrintListServiceImpl;
import com.mhacard.service.DocumentServiceImpl;
import com.mhacard.utils.DateTimeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Controller
public class DataFromMinController {
    @Autowired
    private DocumentServiceImpl docService;

    @Autowired
    private CardPrintListServiceImpl cardPrintingService;

    // Show get data from ministry by document number page
    @RequestMapping(method = RequestMethod.GET, value = "/getCardDataByDocNumber")
    public String index() {

        return "showGetDataFromMin";
    }

    // Function to call API to get data from MInistry
    @RequestMapping(method = RequestMethod.GET, path = "/send_request_api_data")
    public String loadData(@RequestParam(name = "docnumber") String docnumber, Model d) {
        try {

            // Provide available Simple Data
            List<PersonResponse> personList = getSimpleData();

            d.addAttribute("persons", personList);
            d.addAttribute("docnumber", docnumber);
            if (personList.size() > 0) {
                // Send Document date time to attribute
                d.addAttribute("doc_date", DateTimeUtil.dateTimeZoneToDate(personList.get(0).getDoc_date()));
            }

            return "showGetDataFromMin";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getElementValue(String key, Element element) throws Exception {
        try {
            return element.getElementsByTagName(key).item(0).getTextContent();
        } catch (NullPointerException e) {
            throw new Exception("Key Response Exception '" + key + "'' is not exist in response element API");
        }
    }

    public List<PersonResponse> getSimpleData() throws Exception {
        // Pasrse XML Local
        File xmlString = ResourceUtils.getFile("classpath:simple.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(xmlString);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Table");
        List<PersonResponse> personList = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                PersonResponse person = new PersonResponse();
                person.setDoc_no(getElementValue("doc_no", element));
                person.setDoc_date(getElementValue("doc_date", element));
                person.setCreate_by(getElementValue("create_by", element));
                person.setIssue_by(getElementValue("issue_by", element));
                person.setIssue_date(getElementValue("issue_date", element));
                person.setStatus_code(getElementValue("status_code", element));
                person.setNote(getElementValue("note", element));
                person.setAccount_name(getElementValue("account_name", element));
                person.setAccount_number(getElementValue("account_number", element));
                person.setAtmnumber(getElementValue("atm_number", element));
                person.setSocial_card_number(getElementValue("social_card_number", element));
                person.setIdEmployee(getElementValue("IdEmployee", element));
                person.setLaFName(getElementValue("LaFName", element));
                person.setLaLName(getElementValue("LaLName", element));
                person.setEnFName(getElementValue("EnFName", element));
                person.setEnLName(getElementValue("EnLName", element));
                person.setSex(getElementValue("sex", element));
                person.setDOB(DateTimeUtil.dateTimeZoneToDate(getElementValue("DOB", element)));
                person.setDatePermanent(getElementValue("DatePermanent", element));
                person.setPhoto(getElementValue("photo", element));
                person.setTel(getElementValue("Tel", element));
                personList.add(person);
            }
        }
        return personList;
    }

    // Show list of new card to print after get from ministry api
    @RequestMapping(method = RequestMethod.GET, value = "/newListData")
    public String showNewListDataPage() {
        return "showNewListDataPage";
    }

    // Store Information to database local database
    @RequestMapping(method = RequestMethod.GET, value = "/storeCardPrintData/{docnumber}")
    public String storeToLocalDB(@PathVariable(value = "docnumber") String docnumber, HttpSession session) {
        try {

            List<PersonResponse> listPerson = getSimpleData();
            if (listPerson.size() > 0) {
                PersonResponse person = listPerson.get(0);

                com.mhacard.model.Document rootDoc = new com.mhacard.model.Document();

                rootDoc.setDocNumber(docnumber);
                rootDoc.setDocDate(DateTimeUtil.toYYYYMMdd(DateTimeUtil.dateTimeZoneToDate(person.getDoc_date())));
                rootDoc.setPrintTotal(listPerson.size());
                rootDoc.setAddDate(null);
                rootDoc.setAddBy("Jack");
                rootDoc.setPrintStatus("PENDING");
                long lastid = docService.add(rootDoc);

                // Add item that need to print
                for (int i = 0; i < listPerson.size(); i++) {
                    CardPrintingList card = new CardPrintingList();
                    System.out.println(listPerson.get(i).getIssue_date());
                    card.setIssue_by(listPerson.get(i).getIssue_by());
                    card.setIssue_date(DateTimeUtil
                            .toYYYYMMdd(DateTimeUtil.dateTimeZoneToDate(listPerson.get(i).getIssue_date())));
                    card.setAccount_name(listPerson.get(i).getAccount_name());
                    card.setAccount_number(listPerson.get(i).getAccount_number());
                    card.setNote(listPerson.get(i).getNote());
                    card.setLaFName(listPerson.get(i).getLaFName());
                    card.setLaLName(listPerson.get(i).getLaLName());
                    card.setEnFName(listPerson.get(i).getEnFName());
                    card.setEnLname(listPerson.get(i).getEnLName());
                    card.setDob(DateTimeUtil.toYYYYMMdd(listPerson.get(i).getDOB()));
                    card.setDatePermanent(DateTimeUtil
                            .toYYYYMMdd(DateTimeUtil.dateTimeZoneToDate(listPerson.get(i).getDatePermanent())));
                    card.setIdEmployee(listPerson.get(i).getIdEmployee());
                    card.setSocial_card_number(listPerson.get(i).getSocial_card_number());
                    card.setAtm_number(listPerson.get(i).getAtmnumber());
                    cardPrintingService.add(card);
                }
                session.setAttribute("newPrintOrder", docnumber);

                return "redirect:/storeCardPrintCompleted";
            }

            return "redirect:/getCardDataByDocNumber";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/storeCardPrintCompleted")
    public String showCompletedPAddPage(HttpSession session) {
        try {
            System.out.println(session.getAttribute("newPrintOrder"));
            
            if (session.getAttribute("newPrintOrder") != null) {
                session.removeAttribute("newPrintOrder");
                return "showCompletedAddNewPrint";
            }

            return "redirect:/getCardDataByDocNumber";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/getCardDataByDocNumber";
        }

    }

}
