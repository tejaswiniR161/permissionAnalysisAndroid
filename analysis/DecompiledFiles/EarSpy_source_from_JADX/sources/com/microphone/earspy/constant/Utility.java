package com.microphone.earspy.constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Utility {
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            return ((CharacterData) child).getData();
        }
        return "?";
    }

    public static String getData(String strUrl) throws ClientProtocolException, IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(new DefaultHttpClient().execute(new HttpGet(strUrl)).getEntity().getContent()));
        StringBuffer buffer = new StringBuffer();
        while (true) {
            String line = rd.readLine();
            if (line == null) {
                return buffer.toString();
            }
            buffer.append(line);
        }
    }
}
