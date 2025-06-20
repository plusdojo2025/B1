package test;

import java.util.List;

import dao.CategoriesDao;
import dao.PlacesDao;
import dao.ToolsDao;
import dto.Categories;
import dto.Places;
import dto.Tools;

public class FindAllTest {

	public static void main(String[] args) {
		// カテゴリ一覧取得
	    CategoriesDao catsDao = new CategoriesDao();
	    List<Categories> categoList = catsDao.findAll();
	    System.out.println("カテゴリ");
	    //出力
        for (Categories category : categoList) {
            System.out.println(category.getId() + ": " + category.getCategory());
        }
        
		// 場所一覧取得
	    PlacesDao placeDao = new PlacesDao();
	    List<Places> placeList = placeDao.findAll();
	    System.out.println("場所");
	    //出力
        for (Places place : placeList) {
            System.out.println(place.getId() + ": " + place.getPlace());
        }
        
		// 使用物一覧取得
	    ToolsDao toolDao = new ToolsDao();
	    List<Tools> tooList = toolDao.findAll();
	    System.out.println("使用物");
	    //出力
        for (Tools tool : tooList) {
            System.out.println(tool.getId() + ": " + tool.getTool());
        }

	}

}
