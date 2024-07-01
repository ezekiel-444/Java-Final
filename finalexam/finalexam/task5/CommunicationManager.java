package finalexam.task5;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CommunicationManager {

    private String endpoint;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendUserMessage(String message) {
        try {
            // Create the URL and open a connection
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            conn.setRequestMethod("POST");

            // Set the request properties
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            // Enable input and output streams
            conn.setDoOutput(true);

            // Create the JSON payload
            String jsonInputString = "{\"message\": \"" + message + "\"}";

            // Write the JSON payload to the output stream
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Check the response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "Message sent successfully!";
            } else {
                return "Failed to send message. HTTP response code: " + responseCode;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
