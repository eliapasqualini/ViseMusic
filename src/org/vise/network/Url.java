package org.vise.network;

/**
 * 
 * @author marcopazzaglia
 *
 */
public class Url {

   private String url;

   Url() {
       url = "http://www.idiplomati.it/ViseAPI/API/";
   }
   /**
    * 
    * @return 
    *        the url for registration and login
    *
    */
   public final String getUrl() {
        return this.url;
   }

}
