package me.veezol.rpgmc.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.veezol.rpgmc.RPGMC;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JsonData extends Database {

    private final File dataFile;
    private JsonObject database;

    public JsonData() {
        File pluginFolder = RPGMC.getPlugin(RPGMC.class).getDataFolder();
        File dataFolder = new File(pluginFolder, "data");
        if (!dataFolder.exists() && !dataFolder.mkdirs()) {
            throw new RuntimeException("Could not create data folder!");
        }

        dataFile = new File(dataFolder, "data.json");
        try {
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create data file!", e);
        }
    }

    @Override
    public boolean connect() {
        try {
            // Parse the data file to a JsonObject
            database = JsonParser.parseReader(Files.newBufferedReader(dataFile.toPath(), StandardCharsets.UTF_8)).getAsJsonObject();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void close() {
        try {
            // Save the data
            Files.writeString(dataFile.toPath(), database.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
