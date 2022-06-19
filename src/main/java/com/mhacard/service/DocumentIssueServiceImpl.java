package com.mhacard.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DocumentIssueServiceImpl {


	@Value("${Get_DOCUMENT_ISSUE_URL}")
	private String GET_DOCUMENT_ISSUE_URL;

	public String getDocumentData(String docNo) throws Exception {

		String url = GET_DOCUMENT_ISSUE_URL;

		URL urlObject = new URL(url);

		HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

		String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <tem:Auth_login>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:username>UAT</tem:username>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:pwd>BFG779448DBDD5CFDB5C7900F7FE7D61E2B5C7623E8DSE</tem:pwd>\r\n"
				+ "      </tem:Auth_login>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:getdocument_card_issue>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:document_no>" + docNo + "</tem:document_no>\r\n"
				+ "      </tem:getdocument_card_issue>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		con.setDoOutput(true);

		DataOutputStream writer = new DataOutputStream(con.getOutputStream());

		writer.writeBytes(xml);
		writer.flush();
		writer.close();

		String responseStatus = con.getResponseMessage();
		System.out.println(responseStatus);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

		String lineInput;
		StringBuffer response = new StringBuffer();

		while ((lineInput = in.readLine()) != null) {
			response.append(lineInput);
		}

		in.close();
		// System.out.println(response.toString());

		return response.toString();
	}

}
