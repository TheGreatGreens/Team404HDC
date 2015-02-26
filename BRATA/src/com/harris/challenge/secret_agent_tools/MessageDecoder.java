/*------------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *------------------------------------------------------------------------------
 */

package com.harris.challenge.secret_agent_tools;


/**
 * Class to hold and interpret data returned from the MasterServer.  
 */
public class MessageDecoder {
    
    /**
     * Variable for holding the last encoded message return from 
     * the MasterServer; Publicly accessible to other activities
     */
    static String encodedMessage = "---";
    
    /**
     * Variable for holding the decoded result of the last message return
     * from the MasterServer; Publicly accessible to other activities
     */
    static String decodedMessage = "---";
    
    /**
     * Function for getting a decoded message given an encoded message.  
     * Each team must implement this function.
     * 
     * Example:
     * decodeResponse("U__sFLeou_rktcehe!e,~"); should return a result of "Use_the_Force,_Luke!~"
     */
    public static String decodeResponse(String encodedString)
    {
        MessageDecoder.encodedMessage = encodedString;
        
		int factor = 0;
		int strIndex = 0;
		int nextRow = 1;
		for (int i = 2; i<MessageDecoder.encodedMessage.length(); i++){
			if (MessageDecoder.encodedMessage.length() % i == 0){
				factor = i;
				break;
			}
		}
		while (nextRow <= factor){
			if(strIndex >= MessageDecoder.encodedMessage.length()){
				strIndex = nextRow;
				nextRow++;
			}
			else{
				MessageDecoder.decodedMessage = MessageDecoder.decodedMessage + MessageDecoder.encodedMessage.charAt(strIndex);
				strIndex += factor;
			}
		}
		
        return MessageDecoder.decodedMessage;
    }
}
