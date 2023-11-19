package me.veezol.rpgmc.data;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB extends Database {

    private MongoDatabase mongoDatabase;
    private MongoClient mongoClient;

    @Override
    public boolean connect() {
        try {
            ConnectionString connectionString = new ConnectionString(
                    "mongodb+srv://" +
                            mainConfig.mongoDBUsername() +
                            ":" +
                            mainConfig.mongoDBPassword() +
                            "@" +
                            mainConfig.mongoDBURI() +
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
            mongoDatabase = mongoClient.getDatabase(mainConfig.mongoDatabaseName());
        } catch (IllegalArgumentException exception) {
            plugin.getLogger().severe("Cannot connect to MongoDB: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void close() {
        mongoClient.close();
    }


}
