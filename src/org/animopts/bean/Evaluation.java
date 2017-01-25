package org.animopts.bean;

import java.io.Serializable;

public class Evaluation implements Serializable {

	public static final String TABLE_NAME = "evaluation";
	public static final String COL_ID = "evaluationid";
	public static final String COL_REQUESTTUTORID = "requesttutorid";
	public static final String COL_FREQUENCY = "freq";
	public static final String COL_PREPAREDNESS = "prep";
	public static final String COL_EXPLANATION = "exp";
	public static final String COL_EXERCISE = "exc";
	public static final String COL_RELEVANCE = "rel";
	public static final String COL_ENTHUSIASM = "ent";
	public static final String COL_CONFIDENCE = "con";
	public static final String COL_KNOWLEDGEABLE = "kno";
	public static final String COL_VOCAL = "voc";
	public static final String COL_QNA = "que";
	public static final String COL_EFFECTIVENESS = "eff";
	public static final String COL_ENCOURAGING = "enc";
	public static final String COL_PASSION = "pas";
	public static final String COL_TUTEE_LEARNING = "tutee_lrn";
	public static final String COL_TUTEE_UNDERSTANDING = "tutee_und";
	public static final String COL_TUTEE_EFFECTIVENESS = "tutee_eff";
	public static final String COL_MESSAGE = "message";
	public static final String COL_COMMENT = "comment";
	public static final String COL_SENT = "sent";
	public static final String COL_READ = "read";
	public static final String COL_ANSWERED = "answered";

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public String getCOL_ID() {
		return COL_ID;
	}

	public String getCOL_REQUESTTUTORID() {
		return COL_REQUESTTUTORID;
	}

	public String getCOL_FREQUENCY() {
		return COL_FREQUENCY;
	}

	public String getCOL_PREPAREDNESS() {
		return COL_PREPAREDNESS;
	}

	public String getCOL_EXPLANATION() {
		return COL_EXPLANATION;
	}

	public String getCOL_EXERCISE() {
		return COL_EXERCISE;
	}

	public String getCOL_RELEVANCE() {
		return COL_RELEVANCE;
	}

	public String getCOL_ENTHUSIASM() {
		return COL_ENTHUSIASM;
	}

	public String getCOL_CONFIDENCE() {
		return COL_CONFIDENCE;
	}

	public String getCOL_KNOWLEDGEABLE() {
		return COL_KNOWLEDGEABLE;
	}

	public String getCOL_VOCAL() {
		return COL_VOCAL;
	}

	public String getCOL_QNA() {
		return COL_QNA;
	}

	public String getCOL_EFFECTIVENESS() {
		return COL_EFFECTIVENESS;
	}

	public String getCOL_ENCOURAGING() {
		return COL_ENCOURAGING;
	}

	public String getCOL_PASSION() {
		return COL_PASSION;
	}

	public String getCOL_MESSAGE() {
		return COL_MESSAGE;
	}

	public String getCOL_COMMENT() {
		return COL_COMMENT;
	}

	public String getCOL_SENT() {
		return COL_SENT;
	}

	public String getCOL_READ() {
		return COL_READ;
	}

	public String getCOL_ANSWERED() {
		return COL_ANSWERED;
	}

	public String getCOL_TUTEE_LEARNING() {
		return COL_TUTEE_LEARNING;
	}

	public String getCOL_TUTEE_UNDERSTANDING() {
		return COL_TUTEE_UNDERSTANDING;
	}

	public String getCOL_TUTEE_EFFECTIVENESS() {
		return COL_TUTEE_EFFECTIVENESS;
	}

	private float evaluationid;
	private RequestTutor requestTutor;
	private float freq;
	private float prep;
	private float exp;
	private float exc;
	private float rel;
	private float ent;
	private float con;
	private float kno;
	private float voc;
	private float que;
	private float eff;
	private float enc;
	private float pas;
	private float tutee_lrn;
	private float tutee_und;
	private float tutee_eff;
	private String message;
	private String comment;
	private boolean sent;
	private boolean read;
	private boolean answered;

	public Evaluation() {

	}

	public float getEvaluationid() {
		return evaluationid;
	}

	public RequestTutor getRequestTutor() {
		return requestTutor;
	}

	public float getFreq() {
		return freq;
	}

	public float getPrep() {
		return prep;
	}

	public float getExp() {
		return exp;
	}

	public float getExc() {
		return exc;
	}

	public float getRel() {
		return rel;
	}

	public float getEnt() {
		return ent;
	}

	public float getCon() {
		return con;
	}

	public float getKno() {
		return kno;
	}

	public float getVoc() {
		return voc;
	}

	public float getQue() {
		return que;
	}

	public float getEnc() {
		return enc;
	}

	public float getEff() {
		return eff;
	}

	public float getPas() {
		return pas;
	}

	public String getMessage() {
		return message;
	}

	public String getComment() {
		return comment;
	}

	public boolean getSent() {
		return sent;
	}

	public boolean getRead() {
		return read;
	}

	public boolean getAnswered() {
		return answered;
	}

	public void setEvaluationid(float evaluationid) {
		this.evaluationid = evaluationid;
	}

	public void setRequestTutor(RequestTutor requestTutor) {
		this.requestTutor = requestTutor;
	}

	public void setFreq(float freq) {
		this.freq = freq;
	}

	public void setPrep(float prep) {
		this.prep = prep;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	public void setExc(float exc) {
		this.exc = exc;
	}

	public void setRel(float rel) {
		this.rel = rel;
	}

	public void setEnt(float ent) {
		this.ent = ent;
	}

	public void setCon(float con) {
		this.con = con;
	}

	public void setKno(float kno) {
		this.kno = kno;
	}

	public void setVoc(float voc) {
		this.voc = voc;
	}

	public void setQue(float que) {
		this.que = que;
	}

	public void setEff(float eff) {
		this.eff = eff;
	}

	public void setPas(float pas) {
		this.pas = pas;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

	public float getTutee_lrn() {
		return tutee_lrn;
	}

	public float getTutee_und() {
		return tutee_und;
	}

	public float getTutee_eff() {
		return tutee_eff;
	}

	public void setEnc(float enc) {
		this.enc = enc;
	}

	public void setTutee_lrn(float tutee_lrn) {
		this.tutee_lrn = tutee_lrn;
	}

	public void setTutee_und(float tutee_und) {
		this.tutee_und = tutee_und;
	}

	public void setTutee_eff(float tutee_eff) {
		this.tutee_eff = tutee_eff;
	}

}
