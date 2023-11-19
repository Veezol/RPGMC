package me.veezol.rpgmc.data;

import me.veezol.rpgmc.RPGMC;
import me.veezol.rpgmc.config.MainConfig;

/*
This class is in charge of reading & writing data.
*/
public abstract class Database {

    protected final RPGMC plugin = RPGMC.getPlugin(RPGMC.class);
    protected final MainConfig mainConfig = plugin.getMainConfig();

    public Database() {

    }

    // Connect to the database
    public abstract boolean connect();

    public abstract void close();

    public static Database getDatabase(MainConfig config) {
       if (config.mongoDBEnabled()) {
           return new MongoDB();
       }
       return new JsonData();
    }

}
