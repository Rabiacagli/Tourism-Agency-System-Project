package business;

import core.Helper;
import dao.HotelDao;
import entity.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private final HotelDao hotelDao;

    public HotelManager() {
        this.hotelDao = new HotelDao();
    }

    //otel tablosu için bir Arraylist oluşturuyoruz
    public ArrayList<Object[]> getForTable(int size, ArrayList<Hotel> hotels) {
        ArrayList<Object[]> hotelObjList = new ArrayList<>();
        for (Hotel obj : hotels) {
            Object[] rowObject = new Object[size];

            int i = 0;                // otelin özelliklerini tabloya ekliyoruz
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getName();
            rowObject[i++] = obj.getAddress();
            rowObject[i++] = obj.getMail();
            rowObject[i++] = obj.getPhone();
            rowObject[i++] = obj.getStar();
            rowObject[i++] = obj.isCarPark();
            rowObject[i++] = obj.isWifi();
            rowObject[i++] = obj.isPool();
            rowObject[i++] = obj.isFitness();
            rowObject[i++] = obj.isConcierge();
            rowObject[i++] = obj.isSpa();
            rowObject[i++] = obj.isRoomService();

            hotelObjList.add(rowObject);
        }
        return hotelObjList;
    }

    public ArrayList<Hotel> findAll() {  // Hoteldao'dan gelen metod
        return this.hotelDao.findAll();
    }

    public boolean save(Hotel hotel) {    // Helper sınıfından  gelen save metodu
        if (hotel.getId() != 0) {
            Helper.showMsg("error");
        }
        return this.hotelDao.save(hotel);
    }

    public Hotel getById(int id) {  // otel id'sine göre oteli alır
        return this.hotelDao.getById(id);
    }
    public String getByName(int id){    // otel ismine oteli alır
        return this.hotelDao.getByName(id);
    }
    public int getByHotelId(String hotelName) {  // otel adına göre id alır
        return this.hotelDao.getByHotelId(hotelName);
    }

    public boolean update(Hotel hotel) {     // otel güncelleme
        if (this.getById(hotel.getId()) == null) {
            Helper.showMsg("notfound");
        }
        return this.hotelDao.update(hotel);
    }

    public boolean delete(int id) {      // otel silme
        if (this.getById(id) == null) {
            Helper.showMsg("notfound");
            return false;
        }
        return this.hotelDao.delete(id);
    }
    public List<String> getAllHotelsName(){
        return this.hotelDao.getAllHotelsName();
    } // tüm otel isimlerini döndüren Arraylist

}






