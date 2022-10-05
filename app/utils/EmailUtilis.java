/*
 * Copyright (C) Intraway Corporation - All Rights Reserved (2020)
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *
 * Proprietary and confidential
 *
 * This file is subject to the terms and conditions defined in file LICENSE.txt, which is part of this source code
 * package.
 */
package utils;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import play.Play;

public class EmailUtilis {

  private String from;

  private String subject;

  private String htmlMsg;

  private List<String> adds;

  private EmailAttachment attach;

  
  /**
   * @return the from
   */
  public String getFrom() {
    return from;
  }


  /**
   * @param from the from to set
   */
  public void setFrom(String from) {
    this.from = from;
  }


  /**
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }


  /**
   * @param subject the subject to set
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }


  /**
   * @return the htmlMsg
   */
  public String getHtmlMsg() {
    return htmlMsg;
  }


  /**
   * @param htmlMsg the htmlMsg to set
   */
  public void setHtmlMsg(String htmlMsg) {
    this.htmlMsg = htmlMsg;
  }


  /**
   * @return the adds
   */
  public List<String> getAdds() {
    return adds;
  }


  /**
   * @param adds the adds to set
   */
  public void setAdds(List<String> adds) {
    this.adds = adds;
  }

  /**
   * @return the attach
   */
  public EmailAttachment getAttach() {
    return attach;
  }


  /**
   * @param attach the attach to set
   */
  public void setAttach(EmailAttachment attach) {
    this.attach = attach;
  }


  public void enviar() throws EmailException {
	  
	HtmlEmail mail = new HtmlEmail();
    mail.setHostName("smtp-relay.sendinblue.com");
    mail.setSmtpPort(587);
    mail.setAuthenticator(new DefaultAuthenticator(Play.application().configuration().getString("email.authenticator.user"), Play.application().configuration().getString("email.authenticator.pass")));
    mail.setFrom(getFrom());

    if (getAttach() != null) {
      mail.attach(getAttach());
    }

    mail.setSubject(getSubject());
    mail.setHtmlMsg(getHtmlMsg());

    for (String s : getAdds()) {
      mail.addTo(s);
    }
    mail.send();
  }


}
