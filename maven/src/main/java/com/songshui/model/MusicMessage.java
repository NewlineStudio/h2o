package com.songshui.model;

public class MusicMessage extends BaseMessage{
	// �������
	private String Title;
	// ��������
	private String Description;
	// ��������
	private String MusicUrl;
	// �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
	private String HQMusicUrl;

	public MusicMessage(String Title, String Description, String MusicUrl,
			String HQMusicUrl) {
		this.Description = Description;
		this.HQMusicUrl = HQMusicUrl;
		this.MusicUrl = MusicUrl;
		this.Title = Title;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
}
