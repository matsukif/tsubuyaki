package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import model.Mutter;

public class MutterDAO {
	private final String JDBC_URL =	"jdbc:mariadb://localhost/tsubuyaki";
	private final String DB_USER = "root";
	private final String DB_PASS = "fmjn0506";
		
	//findAll()でMutter情報を返す
	public List<Mutter> findAll(){
		
		//Emproyeeリストを作成
		List<Mutter>  mutterList = new ArrayList();
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
				 
			//SELECT文を準備
			String sql = "SELECT id,userName,text,datetime from mutter order by id desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
				 
			//SELECTを実行し結果表（ResultSet）を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコード内容をEmproyeeインスタンスに格納しArrayListに追加
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String text = rs.getString("text"); 
//				Date date = rs.getDate("datetime");
				Timestamp date = rs.getTimestamp("datetime");
				
				Mutter mutter = new Mutter(id, userName, text, date);
				mutterList.add(mutter);
			}
				 
		} catch (SQLException e) {
			 e.printStackTrace();
		}

		return mutterList;
	
	}
	
	/*
	//createの前にjava.sql.Date型の現在日時を取得する
	public java.sql.Date getCurrentDate(){
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	*/
	
	public boolean create (Mutter mutter) {
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			//登録する値を取得
			String userName = mutter.getUserName();
			String text = mutter.getText();
//			Date date = mutter.getDate();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//			timestamp = sdf.format(timestamp);
			
			
			//INSERT文を準備
			String sql = "INSERT into mutter(userName,text,datetime) values(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
			//INSER文の「?」に使用する値を設定しSQLを完成させる
			pStmt.setString(1, userName);
			pStmt.setString(2, text);
//			pStmt.setDate(3,getCurrentDate());
			pStmt.setTimestamp(3,timestamp);
		
			
			//INSERT文を実行（resultには挿入された行数が代入）
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		return true;
	
	}		

	
	
}
