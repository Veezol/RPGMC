package me.veezol.rpgmc.data;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class PlayerData {
    private MongoClient mongoClient;

    public PlayerData() {

    }

    public void connect(String userName, String password, String URI) {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://" +
                        userName +
                        ":" +
                        password +
                        "@" +
                        URI +
                        "/?retryWrites = true & w = majority"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .retryWrites(true)
                .retryReads(true)
                .build();
        mongoClient = MongoClients.create(settings);
    }
    public void close() {
        mongoClient.close();
    }

}
