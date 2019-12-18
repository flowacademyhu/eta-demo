package hu.flowacademy.eta.demo.spacexstatus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class SpacexService {

    public List<Rocket> getRockets() {
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.spacexdata.com/v3/rockets"))
                .GET().build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), new TypeToken<List<Rocket>>() {
            }.getType());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return List.of();
        }
    }

}
