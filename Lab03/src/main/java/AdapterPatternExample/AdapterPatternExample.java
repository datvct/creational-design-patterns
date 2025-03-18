package AdapterPatternExample;

// Hệ thống chỉ hỗ trợ XML
class XMLService {
    public String getXMLData() {
        return "<data><name>John Doe</name><age>30</age></data>";
    }
}

// Adapter chuyển XML thành JSON
class XMLToJSONAdapter {
    private XMLService xmlService;

    public XMLToJSONAdapter(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    public String getJSONData() {
        // Chuyển đổi XML thành JSON (đơn giản hóa)
        String xml = xmlService.getXMLData();
        String json = xml.replace("<data>", "{")
                .replace("</data>", "}")
                .replace("<name>", "\"name\": \"")
                .replace("</name>", "\", ")
                .replace("<age>", "\"age\": \"")
                .replace("</age>", "\"");
        return "{" + json + "}";
    }
}

// Hệ thống khách hàng sử dụng JSON
class JSONClient {
    public void displayData(String jsonData) {
        System.out.println("📄 JSON Data: " + jsonData);
    }
}

// Test chương trình
public class AdapterPatternExample {
    public static void main(String[] args) {
        XMLService xmlService = new XMLService();
        XMLToJSONAdapter adapter = new XMLToJSONAdapter(xmlService);

        JSONClient jsonClient = new JSONClient();
        jsonClient.displayData(adapter.getJSONData());
    }
}
