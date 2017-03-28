package com.jsc.ex1;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LDAPTest {
	static String ATTRIBUTE_FOR_USER = "sAMAccountName";
	private static Attributes authenticateUser(String username, String password, String domainName, String host, String dn)
    {
          String returnedAtts[] ={ "sn", "givenName", "mail" };
          String searchFilter = "(&(objectClass=user)(" + ATTRIBUTE_FOR_USER + "=" + username + "))";
          //Create the search controls
          SearchControls searchCtls = new SearchControls();
          searchCtls.setReturningAttributes(returnedAtts);
          //Specify the search scope
          searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
          Hashtable<String,String> environment = new Hashtable<String,String>();
          environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
          //Using starndard Port, check your instalation
          environment.put(Context.PROVIDER_URL, "ldap://" + host + ":389");
          environment.put(Context.SECURITY_AUTHENTICATION, "simple");
          environment.put(Context.SECURITY_PRINCIPAL, username + "@" + domainName);
          environment.put(Context.SECURITY_CREDENTIALS, password);
          LdapContext ctxGC = null;
          try
          {
                ctxGC = new InitialLdapContext(environment, null);
                //    Search for objects in the GC using the filter
                NamingEnumeration<SearchResult> answer = ctxGC.search(dn, searchFilter, searchCtls);
                while (answer.hasMoreElements())
                {
                      SearchResult sr = (SearchResult)answer.next();
                      Attributes attrs = sr.getAttributes();
                      if (attrs != null)
                      {
                            return attrs;
                      }
                }
           }
          catch (NamingException e)
          {
                System.out.println("Just reporting error");
                e.printStackTrace();
          }
          return null;
    }
       
      public static void main(String[] args) {
            //Yo specify in the authenticate user the attributes that you want returned
            //Some companies use standard attributes like 'description' to hold an employee ID
            //The ActiveDirectory data can be enhanced to add custom attributes like
            //printer
            // Some instalations usually have several ACtiveDirectoryServers, lets say
            // 192.150.0.8, 192.150.0.7 y 192.150.0.9 and they use a
            // DNS round robin to balance the load
            Attributes att = LDAPTest.authenticateUser("akganipineni", args[0], "adaequare.com", "HITEXADC.ADAEQUARE.COM", "DC=adaequare,DC=com");
            if (att == null) {
                  System.out.println("Sorry your use is invalid or password incorrect");
            } else {
                  try {
					System.out.println(att.get("givenName").get().toString() + " " +att.get("sn").get().toString() + "'s Mail id is : " + att.get("mail").get().toString());
				} catch (NamingException e) {
					e.printStackTrace();
				}
            }
      }
}