package com.sentiment.hackathon_app.model;
public class SentimentResponse{

	public SentimentResponse(String sentence, Float npol, Float ppol, Float cpol, Float natpol) {
		super();
		this.sentence = sentence;
		this.npol = npol;
		this.ppol = ppol;
		this.cpol = cpol;
		this.natpol = natpol;
	}
	String sentence = "";
    Float npol = 0.0F;
    Float ppol = 0.0F;
    Float cpol = 0.0F;
    Float natpol = 0.0F;
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public Float getNpol() {
		return npol;
	}
	public void setNpol(Float npol) {
		this.npol = npol;
	}
	public Float getPpol() {
		return ppol;
	}
	public void setPpol(Float ppol) {
		this.ppol = ppol;
	}
	public Float getCpol() {
		return cpol;
	}
	public void setCpol(Float cpol) {
		this.cpol = cpol;
	}
	public Float getNatpol() {
		return natpol;
	}
	public void setNatpol(Float natpol) {
		this.natpol = natpol;
	}
}
