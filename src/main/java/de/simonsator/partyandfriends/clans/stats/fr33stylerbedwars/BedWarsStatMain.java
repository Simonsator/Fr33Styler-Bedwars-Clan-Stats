package de.simonsator.partyandfriends.clans.stats.fr33stylerbedwars;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.clan.commands.ClanCommands;
import de.simonsator.partyandfriends.clan.commands.subcommands.Stats;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import de.simonsator.partyandfriends.utilities.Language;

import java.io.File;
import java.io.IOException;

public class BedWarsStatMain extends PAFExtension {

	public void onEnable() {
		try {
			ConfigurationCreator config = new BWSConfig(new File(getDataFolder(), "config.yml"), this);
			ConfigurationCreator messagesConfig = new BWSMessages(Language.OWN, new File(getDataFolder(), "messages.yml"), this);
			BWConnection connection = new BWConnection(config.getString("database.db"), "jdbc:mysql://" + config.getString("database.host") + ":" + config.getInt("database.port"), config.getString("database.user"), config.getString("database.password"), config.getBoolean("database.ssl"));
			((Stats) ClanCommands.getInstance().getSubCommand(Stats.class)).registerClanStats(new BWStat(connection, messagesConfig), this);
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}