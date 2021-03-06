package com.cgi.sandbox.xml;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by galloisg on 08/07/2016.
 */
public class JSONjava {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
            "<?xml version=\"1.0\"?>\n" +
                    "<feed xmlns=\"http://www.w3.org/2005/Atom\">\n" +
                    "  <entry id=\"1\">\n" +
                    "    <name>Homer Simpson</name>\n" +
                    "    <birthday>1956-03-01</birthday>\n" +
                    "    <email xmlns=\"http://www.w3.org/2007/app\">chunkylover53@aol.com</email>\n" +
                    "    <phoneNumbers>\n" +
                    "      <home>5551234</home>\n" +
                    "      <mobile>5555678</mobile>\n" +
                    "      <work>5559991</work>\n" +
                    "    </phoneNumbers>\n" +
                    "  </entry>\n" +
                    "  <entry id=\"2\">\n" +
                    "    <name>Marge Simpson</name>\n" +
                    "    <birthday>1965-03-01</birthday>\n" +
                    "    <email xmlns=\"http://www.w3.org/2007/app\">chunkylover53@aol.com</email>\n" +
                    "    <phoneNumbers>\n" +
                    "      <home>152154</home>\n" +
                    "      <work>18644</work>\n" +
                    "    </phoneNumbers>\n" +
                    "  </entry>\n" +
                    "</feed>";

    public static String TEST_TIBCO_STRING = "<xml-fragment>\n" +
            "   <proc:basicProcessTemplate xmlns:proc=\"http://www.tibco.com/bx/2009/management/processManagerType\">\n" +
            "      <proc:processQName>\n" +
            "         <proc:moduleName>/ProcessEERPRO/ProcessPackages/ProcessEERPRO.xpdl</proc:moduleName>\n" +
            "         <proc:processName>ProcessEERPROProcess</proc:processName>\n" +
            "         <proc:version>2.0.0.20160627145703568</proc:version>\n" +
            "         <proc:props type=\"displayedName\">ProcessEERPRO</proc:props>\n" +
            "         <proc:props type=\"sortVersion\">2.0</proc:props>\n" +
            "      </proc:processQName>\n" +
            "      <proc:description>*** Generated by TIBCO Business Studio.</proc:description>\n" +
            "   </proc:basicProcessTemplate>\n" +
            "   <proc:basicProcessTemplate xmlns:proc=\"http://www.tibco.com/bx/2009/management/processManagerType\">\n" +
            "      <proc:processQName>\n" +
            "         <proc:moduleName>/ProcessEERPRO/ProcessPackages/ProcessEERPRO.xpdl</proc:moduleName>\n" +
            "         <proc:processName>ProcessEERPROProcess</proc:processName>\n" +
            "         <proc:version>2.0.0.20160630094916359</proc:version>\n" +
            "      </proc:processQName>\n" +
            "      <proc:description>*** Generated by TIBCO Business Studio.</proc:description>\n" +
            "   </proc:basicProcessTemplate>\n" +
            "</xml-fragment>";

    public static String SIMPE_XML = "<?xml version=\"1.0\"?>\n" +
            "<customer>\n" +
            "    <first-name>Jane</first-name>\n" +
            "    <last-name>Doe</last-name>\n" +
            "    <address>\n" +
            "        <street>123 A Street</street>\n" +
            "    </address>\n" +
            "    <phone-number type=\"work\">555-1111</phone-number>\n" +
            "    <phone-number type=\"cell\">555-2222</phone-number>\n" +
            "</customer>";

    public static String CASE_XML_TEST = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<bdstests:HARMONIE_EERPROElement xmlns:bdstests=\"http://harmonie.socgen.com/bdstests\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"bdstests:HARMONIE_EERPRO\">\n" +
            "   <cid>1816</cid>\n" +
            "   <comptes xsi:type=\"bdstests:EERPRO_ACCOUNT\">\n" +
            "      <numrodecompte>6816ez81r6z1e8</numrodecompte>\n" +
            "      <montantduversement>15050.0</montantduversement>\n" +
            "   </comptes>\n" +
            "   <comptes xsi:type=\"bdstests:EERPRO_ACCOUNT\">\n" +
            "      <numrodecompte>6816ez81r6z1e8</numrodecompte>\n" +
            "      <montantduversement>1500.0</montantduversement>\n" +
            "   </comptes>\n" +
            "</bdstests:HARMONIE_EERPROElement>";


    public static void main(String[] args) {
        try {
            System.out.println(CASE_XML_TEST);
            // XML -> JSON
            JSONObject xmlJSONObj = XML.toJSONObject(CASE_XML_TEST);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);

            // JSON -> XML
            JSONObject json = new JSONObject(jsonPrettyPrintString);
            String xml = XML.toString(json);
            System.out.println(xml);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }
}
