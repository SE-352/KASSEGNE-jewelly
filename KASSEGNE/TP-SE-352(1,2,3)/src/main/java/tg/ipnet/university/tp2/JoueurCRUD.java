package tg.ipnet.university.tp2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tg.ipnet.university.tp1.Joueur;

public class JoueurCRUD {

	Database database = new Database();

	public void add(Joueur joueur) throws SQLException{
		
		try(Connection connection = database.getConnection()){
			
			String SQL = "INSERT INTO joueur(nom, prenom, numero_licence, points) VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, joueur.getNom());
			preparedStatement.setString(2, joueur.getPrenom());
			preparedStatement.setString(3, joueur.getNumeroLicence());
			preparedStatement.setInt(4, joueur.getNbrPoints());
			
			int rows = preparedStatement.executeUpdate();
			if(rows > 0) {
				System.out.println("\nDonnées ajoutées avec succès.");
			}else
				System.out.println("\nerreur");
		}
	}
	
	public void findAll() throws SQLException{
		
		try(Connection connection = database.getConnection()){
			String SQL = "SELECT * FROM joueur";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				afficherJoueur(new Joueur(resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getString("numero_licence"),
						resultSet.getInt("points")));
			}
		}
	}
	
	private void afficherJoueur(Joueur joueur) {
		
		System.out.println("Nom du joueur : " + joueur.getNom());
		System.out.println("Prenom du joueur : " + joueur.getPrenom());
		System.out.println("Numero licence du joueur : " + joueur.getNumeroLicence());
		System.out.println("Nombre de points du joueur : " + joueur.getNbrPoints());
		System.out.println("-----------------------------------------------------");
		
	}
	
	public boolean search(String matricule) throws SQLException{
		
		boolean isFound = false;
		
		try(Connection connection = database.getConnection()){
			String SQL = "SELECT * FROM joueur WHERE matricule = " + matricule;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL);
			
			if(resultSet.next()) {
				isFound = true;
				afficherJoueur(new Joueur(
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getString("numero_licence"),
						resultSet.getInt("points")));
			}else
				System.out.println("Joueur non retrouvé.");
			
		}
		return isFound;
	}
	
	public void delete(String matricule) throws SQLException{
		
		try(Connection connection = database.getConnection()){
			String SQL = "DELETE * FROM joueur WHERE matricule = " + matricule;
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(SQL);
			
			if(rows > 0) {
				System.out.println("Joueur supprimé avec succès.");
			}else
				System.out.println("Joueur non supprimé");
		}
	}
	
	public void edit(Joueur joueur, String matricule) throws SQLException{
		
		try(Connection connection = database.getConnection()){
			String SQL = "UPDATE joueur SET nom = ?, prenom = ?, numero_licence = ?, points = ? WHERE matricule = " + matricule;
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, joueur.getNom());
			preparedStatement.setString(2, joueur.getPrenom());
			preparedStatement.setString(3, joueur.getNumeroLicence());
			preparedStatement.setInt(4, joueur.getNbrPoints());
			
			int rows = preparedStatement.executeUpdate();
			if(rows > 0) {
				System.out.println("\nDonnées modifiées avec succès.");
			}else
				System.out.println("\nModification échouée");
		}
	}
}

