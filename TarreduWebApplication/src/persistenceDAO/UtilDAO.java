package persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDAO {

	private DataSource dataSource;

	public UtilDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// Svuota il Database
	public void dropDatabase() {

		Connection connection = dataSource.getConnection();
		try {
	
			String delete = "drop table if exists sequence_data;";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop function if exists nextval;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
	
			delete = "drop table if exists carrello;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists prodottoInCarrello;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists commentoProdotto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists venditoreInPreventivo;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists prodottoInPreventivo;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists preventivo;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists urlImmaginiProdotto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists coloriPerProdotto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists venditorePerProdotto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists prodottiPreferiti;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists prodottiPerConfronto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists utente;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists prodotto;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "drop table if exists venditore;";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			
			
			System.out.println("Executed drop database");

		} catch (SQLException e) {

			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new PersistenceException(e.getMessage());
			}
		}
	}

	// Crea il DataBase
	public void createDatabase() {

		Connection connection = dataSource.getConnection();
		try {

			String  add = "CREATE TABLE `tarreduDB`.`sequence_data` (\r\n" + 
					"    `sequence_name` varchar(100) NOT NULL,\r\n" + 
					"    `sequence_increment` int(11) unsigned NOT NULL DEFAULT 1,\r\n" + 
					"    `sequence_min_value` int(11) unsigned NOT NULL DEFAULT 1,\r\n" + 
					"    `sequence_max_value` bigint(20) unsigned NOT NULL DEFAULT 18446744073709551615,\r\n" + 
					"    `sequence_cur_value` bigint(20) unsigned DEFAULT 1,\r\n" + 
					"    `sequence_cycle` boolean NOT NULL DEFAULT FALSE,\r\n" + 
					"    PRIMARY KEY (`sequence_name`)\r\n" + 
					") ENGINE=MyISAM;";

			
			
			PreparedStatement statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
//			add = "set @@global.max_connections = 1000;";
//			statement = connection.prepareStatement(add);
//			statement.executeUpdate();
			
			add =   "INSERT INTO tarreduDB.sequence_data\r\n" + 
					"    (sequence_name)\r\n" + 
					"VALUE\r\n" + 
					"    ('sq_my_sequence')\r\n" + 
					";";

			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add =   "CREATE FUNCTION `nextval` (`seq_name` varchar(100))\r\n" + 
					"RETURNS bigint(20) NOT DETERMINISTIC\r\n" + 
					"BEGIN\r\n" + 
					"    DECLARE cur_val bigint(20);\r\n" + 
					" \r\n" + 
					"    SELECT\r\n" + 
					"        sequence_cur_value INTO cur_val\r\n" + 
					"    FROM\r\n" + 
					"        tarreduDB.sequence_data\r\n" + 
					"    WHERE\r\n" + 
					"        sequence_name = seq_name\r\n" + 
					"    ;\r\n" + 
					" \r\n" + 
					"    IF cur_val IS NOT NULL THEN\r\n" + 
					"        UPDATE\r\n" + 
					"            tarreduDB.sequence_data\r\n" + 
					"        SET\r\n" + 
					"            sequence_cur_value = IF (\r\n" + 
					"                (sequence_cur_value + sequence_increment) > sequence_max_value,\r\n" + 
					"                IF (\r\n" + 
					"                    sequence_cycle = TRUE,\r\n" + 
					"                    sequence_min_value,\r\n" + 
					"                    NULL\r\n" + 
					"                ),\r\n" + 
					"                sequence_cur_value + sequence_increment\r\n" + 
					"            )\r\n" + 
					"        WHERE\r\n" + 
					"            sequence_name = seq_name\r\n" + 
					"        ;\r\n" + 
					"    END IF;\r\n" + 
					" \r\n" + 
					"    RETURN cur_val;\r\n" + 
					"    END";

			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`utente` (\r\n" 
					+ "  `utente_id` INT NOT NULL,\r\n"
					+ "  `nome` VARCHAR(255) NOT NULL,\r\n" 
					+ "  `cognome` VARCHAR(255) NOT NULL,\r\n"
					+ "  `dataNascita` DATE NOT NULL,\r\n"
					+ "  `dataUltimoAccesso` DATE,\r\n"
					+ "  `email` VARCHAR(255) NOT NULL,\r\n"
					+ "  `numeroTelefonico` VARCHAR(255) NOT NULL,\r\n"
					+ "  `passwordUtente` VARCHAR(255) NOT NULL,\r\n"
					+ "  UNIQUE INDEX `utente_id_UNIQUE` (`utente_id` ASC),\r\n" 
					+ "  PRIMARY KEY (`email`));";

			statement = connection.prepareStatement(add);
			statement.executeUpdate();

			add = "CREATE TABLE `tarreduDB`.`venditore` (\r\n" + 
					"  `id_venditore` INT NOT NULL,\r\n" + 
					"  `nomeTitolare` VARCHAR(255) NOT NULL,\r\n" + 
					"  `cognomeTitolare` VARCHAR(255) NOT NULL,\r\n" + 
					"  `nomeNegozio` VARCHAR(255) NOT NULL,\r\n" + 
					"  `indirizzoVenditore` VARCHAR(255) NOT NULL,\r\n" + 
					"  `emailVenditore` VARCHAR(255) NOT NULL,\r\n" +
					"  `passwordVenditore` VARCHAR(255) NOT NULL,\r\n" +
					"  `latitudineVenditore` VARCHAR(255) NOT NULL,\r\n" +
					"  `longitudineVenditore` VARCHAR(255) NOT NULL,\r\n" +
					"  `descrizioneVenditore` MEDIUMTEXT NOT NULL,\r\n" +
					"  `numeroTelefonicoVenditore` VARCHAR(255) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`emailVenditore`),\r\n" + 
					"  UNIQUE INDEX `id_venditore_UNIQUE` (`id_venditore` ASC));";

			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			

			add = "CREATE TABLE `tarreduDB`.`prodotto` (\r\n" 
					+ "  `id_prodotto` INT NOT NULL,\r\n"
					+ "  `marcaProdotto` VARCHAR(255) NOT NULL,\r\n" 
					+ "  `numeroVisite` INT NOT NULL,\r\n"
					+ "  `ambienteProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `tipoProdotto` VARCHAR(255) NOT NULL,\r\n" 
					+ "  `nomeProdotto` VARCHAR(255) NOT NULL,\r\n" 
					+ "  `prezzoProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `misureProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  `immaginePrincipale` VARCHAR(255) NOT NULL,\r\n"
					+ "  `offertaProdotto` TINYINT NOT NULL,\r\n"
					+ "  `descrizioneProdotto` VARCHAR(255) NOT NULL,\r\n"
					+ "  PRIMARY KEY (`id_prodotto`),\r\n"
					+ "  UNIQUE INDEX `id_prodotto_UNIQUE` (`id_prodotto` ASC));\r\n";
					

			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`preventivo` (\r\n" + 
					"  `id_preventivo` INT(11) NOT NULL,\r\n" + 
					"  `data_ora_preventivo` DATE NOT NULL,\r\n" + 
					"  `id_utente` VARCHAR(255) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`id_preventivo`),\r\n" + 
					"  UNIQUE INDEX `id_preventivo_UNIQUE` (`id_preventivo` ASC),\r\n" + 
					"  INDEX `id_utente_idx` (`id_utente` ASC),\r\n" + 
					"  CONSTRAINT `id_utente`\r\n" + 
					"    FOREIGN KEY (`id_utente`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`email`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`carrello` (\r\n" + 
					"  `id_carrello` INT NOT NULL,\r\n" + 
					"  `email_utente` VARCHAR(255) NOT NULL,\r\n" + 
					"  PRIMARY KEY (`id_carrello`),\r\n" + 
					"  INDEX `emailUtente_idx` (`email_utente` ASC),\r\n" + 
					"  CONSTRAINT `emailUtente`\r\n" + 
					"    FOREIGN KEY (`email_utente`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`email`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
					
			add = "CREATE TABLE `tarreduDB`.`prodottoInCarrello` (\r\n" + 
					"  `id_prodottoInCarrello` INT NOT NULL,\r\n" + 
					"  `email_utenteCarrello` VARCHAR(255) NOT NULL,\r\n" + 
					"  INDEX `id_prodottoInCarrello_idx` (`id_prodottoInCarrello` ASC),\r\n" + 
					"  INDEX `email_utenteCarrello_idx` (`email_utenteCarrello` ASC),\r\n" + 
					"  CONSTRAINT `id_prodottoInCarrello`\r\n" + 
					"    FOREIGN KEY (`id_prodottoInCarrello`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `email_utenteCarrello`\r\n" + 
					"    FOREIGN KEY (`email_utenteCarrello`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`email`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n" + 
					"";
			
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();

			
			add = "CREATE TABLE `tarreduDB`.`commentoProdotto` (\r\n" + 
					"  `id_commentoProdotto` INT NOT NULL,\r\n" + 
					"  `utenteEmail` VARCHAR(255) NOT NULL,\r\n" + 
					"  `idProdotto` INT NOT NULL,\r\n" + 
					"  `commentoProdotto` VARCHAR(255) NULL,\r\n" + 
					"  `valutazioneProdotto` INT NULL,\r\n" + 
					"  PRIMARY KEY (`id_commentoProdotto`),\r\n" + 
					"  INDEX `utenteEmail_idx` (`utenteEmail` ASC),\r\n" + 
					"  INDEX `idProdotto_idx` (`idProdotto` ASC),\r\n" + 
					"  CONSTRAINT `utenteEmail`\r\n" + 
					"    FOREIGN KEY (`utenteEmail`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`email`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `idProdotto`\r\n" + 
					"    FOREIGN KEY (`idProdotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);" ;
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`venditoreInPreventivo` (\r\n" + 
					"  `id_venditoreInPreventivo` INT NOT NULL,\r\n" + 
					"  `venditoreEmail` VARCHAR(255) NOT NULL,\r\n" + 
					"  `preventivoID` INT NOT NULL,\r\n" + 
					"  PRIMARY KEY (`id_venditoreInPreventivo`),\r\n" + 
					"  INDEX `venditoreEmail_idx` (`venditoreEmail` ASC),\r\n" + 
					"  INDEX `preventivoID_idx` (`preventivoID` ASC),\r\n" + 
					"  CONSTRAINT `venditoreEmail`\r\n" + 
					"    FOREIGN KEY (`venditoreEmail`)\r\n" + 
					"    REFERENCES `tarreduDB`.`venditore` (`emailVenditore`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `preventivoID`\r\n" + 
					"    FOREIGN KEY (`preventivoID`)\r\n" + 
					"    REFERENCES `tarreduDB`.`preventivo` (`id_preventivo`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);" ;
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`prodottoInPreventivo` (\r\n" + 
					"  `id_prodottoInPreventivo` INT NOT NULL,\r\n" + 
					"  `preventivoID` INT NOT NULL,\r\n" + 
					"  `prodottoID` INT NOT NULL,\r\n" + 
					"  `richiestaAggiuntiva` VARCHAR(255) NULL,\r\n" + 
					"  PRIMARY KEY (`id_prodottoInPreventivo`),\r\n" + 
					"  INDEX `preventivoID_idx` (`preventivoID` ASC),\r\n" + 
					"  INDEX `prodottoID_idx` (`prodottoID` ASC),\r\n" + 
					"  CONSTRAINT `preventivo_ID`\r\n" + 
					"    FOREIGN KEY (`preventivoID`)\r\n" + 
					"    REFERENCES `tarreduDB`.`preventivo` (`id_preventivo`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `prodotto_ID`\r\n" + 
					"    FOREIGN KEY (`prodottoID`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);" ;
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`urlImmaginiProdotto` (\r\n" + 
					"  `id_prodotto` INT NOT NULL,\r\n" + 
					"  `urlImmagine` VARCHAR(255) NOT NULL,\r\n" + 
					"  INDEX `id_prodotto_idx` (`id_prodotto` ASC),\r\n" + 
					"  CONSTRAINT `id_prodotto`\r\n" + 
					"    FOREIGN KEY (`id_prodotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`coloriPerProdotto` (\r\n" + 
					"  `id_prodotto` INT NOT NULL,\r\n" + 
					"  `coloreProdotto` VARCHAR(255) NOT NULL,\r\n" + 
					"  INDEX `id_prodotto_idx` (`id_prodotto` ASC),\r\n" + 
					"  CONSTRAINT `id_ProdottoColore`\r\n" + 
					"    FOREIGN KEY (`id_prodotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`venditorePerProdotto` (\r\n" + 
					"  `id_prodotto` INT NOT NULL,\r\n" + 
					"  `emailVenditore` VARCHAR(255) NOT NULL,\r\n" + 
					"  INDEX `id_prodotto_idx` (`id_prodotto` ASC),\r\n" + 
					"  CONSTRAINT `id_prodottoPerVenditore`\r\n" + 
					"    FOREIGN KEY (`id_prodotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" +
					"    CONSTRAINT `emailVenditoreProdotto`\r\n" + 
					"    FOREIGN KEY (`emailVenditore`)\r\n" + 
					"    REFERENCES `tarreduDB`.`venditore` (`emailVenditore`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
	
			
			add = "CREATE TABLE `tarreduDB`.`prodottiPreferiti` (\r\n" + 
					"  `id_prodotto` INT NOT NULL,\r\n" + 
					"  `emailUtente` VARCHAR(255) NOT NULL,\r\n" + 
					"  INDEX `idprodottoPreferito_idx` (`id_prodotto` ASC),\r\n" + 
					"  INDEX `emailUtenteProdottoPreferito_idx` (`emailUtente` ASC),\r\n" + 
					"  CONSTRAINT `idprodottoPreferito`\r\n" + 
					"    FOREIGN KEY (`id_prodotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `emailUtenteProdottoPreferito`\r\n" + 
					"    FOREIGN KEY (`emailUtente`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`email`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			add = "CREATE TABLE `tarreduDB`.`prodottiPerConfronto` (\r\n" + 
					"  `id_prodotto` INT NOT NULL,\r\n" + 
					"  `emailUtente` VARCHAR(255) NOT NULL,\r\n" + 
					"  INDEX `idprodottoPerConfronto_idx` (`id_prodotto` ASC),\r\n" + 
					"  INDEX `emailUtenteProdottoPerConfronto_idx` (`emailUtente` ASC),\r\n" + 
					"  CONSTRAINT `idprodottoPerConfronto`\r\n" + 
					"    FOREIGN KEY (`id_prodotto`)\r\n" + 
					"    REFERENCES `tarreduDB`.`prodotto` (`id_prodotto`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE,\r\n" + 
					"  CONSTRAINT `emailUtenteProdottoPerConfronto`\r\n" + 
					"    FOREIGN KEY (`emailUtente`)\r\n" + 
					"    REFERENCES `tarreduDB`.`utente` (`email`)\r\n" + 
					"    ON DELETE CASCADE\r\n" + 
					"    ON UPDATE CASCADE);\r\n";
			
			statement = connection.prepareStatement(add);
			statement.executeUpdate();
			
			
			System.out.println("Executed create database");

		} catch (SQLException e) {

			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				throw new PersistenceException(e.getMessage());
			}
		}
	}

	
	
	
}