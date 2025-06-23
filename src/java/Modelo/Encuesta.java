/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Encuesta {
    int id;
    String resp1;
    String resp2;
    String resp3;

    public Encuesta() {
    }

    public Encuesta(int id, String resp1, String resp2, String resp3) {
        this.id = id;
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResp1() {
        return resp1;
    }

    public void setResp1(String resp1) {
        this.resp1 = resp1;
    }

    public String getResp2() {
        return resp2;
    }

    public void setResp2(String resp2) {
        this.resp2 = resp2;
    }

    public String getResp3() {
        return resp3;
    }

    public void setResp3(String resp3) {
        this.resp3 = resp3;
    }
    
    
}
