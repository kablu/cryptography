package com.crypto.demo.list.providers;

import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Kablu
 *
 */
public class ListAlgorithms {

	 public static void printSet(
		        String setName,
		        Set	   algorithms)
		    {
		        System.out.println(setName + ":");
		        
		        if (algorithms.isEmpty())
		        {
		            System.out.println("            None available.");
		        }
		        else
		        {
		            Iterator	it = algorithms.iterator();
		            
		            while (it.hasNext())
		            {
		                String	name = (String)it.next();
		                
		                System.out.println("            " + name);
		            }
		        }
		    }
	 
	public static void main(String[] args) {
		Provider[] providers = Security.getProviders();
		Set ciphers  = new HashSet();
		Set keyAggreements  = new HashSet();
		Set macs = new HashSet();
		Set messagedigest  = new HashSet();
		Set signatures  = new HashSet();
		
		
		for (int i = 0; i < providers.length; i++) {
			
			Iterator it = providers[i].keySet().iterator();
			
			while (it.hasNext()) {
				String entry = (String) it.next();
				
				System.out.println("entry:" + entry);
				
				if(entry.startsWith("Alg.Alias.")){
					entry = entry.substring("Alg.Alias.".length());
				}
				
				if(entry.startsWith("Cipher.")){
					ciphers.add(entry.substring("Cipher.".length()));
				}
				else if(entry.startsWith("KeyAgreement.")){
					keyAggreements.add(entry.substring("KeyAgreement.".length()));
				}else if (entry.startsWith("Mac."))
                {
                    macs.add(entry.substring("Mac.".length()));
                }
                else if (entry.startsWith("MessageDigest."))
                {
                	messagedigest.add(entry.substring("MessageDigest.".length()));
                }
                else if (entry.startsWith("Signature."))
                {
                    signatures.add(entry.substring("Signature.".length()));
                }
			}
			
		}
		 printSet("Ciphers", ciphers);
	     printSet("KeyAgreeents", keyAggreements);
	     printSet("Macs", macs);
	     printSet("MessageDigests", messagedigest);
	     printSet("Signatures", signatures);
	}
}
