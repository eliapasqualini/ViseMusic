package org.vise.network;


import java.io.IOException;

import org.json.JSONException;

/**
 * 
 * @author marcopazzaglia
 *
 */
public interface Registration {

   /**
    * 
    *  @return
    *          if the registration is ok
    */
    boolean getSuccess();
   /**
    * 
    * @return
    *          the error message
    */
    String getErrorMessage();

   /**
    * 
    * @return
    *          return the correct URL for the registration
    */

    String totalUrl();
   /**
    * 
    * @return
    *          the JSON replaced by the site of the registration
    * @param url
    *          The url used to make the registration
    * @throws IOException
    *          if the URL is not correct
    */
    String run(String url) throws IOException;
   /**
    * 
    * @return
    *           the message of error
    * @throws JSONException
    *           if the JSON is not correct
    */
 
    String getError() throws JSONException;

}
