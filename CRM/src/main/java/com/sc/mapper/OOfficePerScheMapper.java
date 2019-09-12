package com.sc.mapper;

import java.util.List;

import com.sc.bean.OOfficePerSche;

public interface OOfficePerScheMapper {
    int insert(OOfficePerSche record);

    int insertSelective(OOfficePerSche record);
    
    
    //��ӷ���
	public void addSchedule(OOfficePerSche sche);
	
    //ͨ��id��ȡʵ�������
	public OOfficePerSche getScheduleById(String id);
	
	//�޸ķ���
	public void updateSchedule(OOfficePerSche sche);
	
	//ɾ������
	public void delSchedule(OOfficePerSche sche);
	
	//��ѯ����
	public List getAllSchedule(OOfficePerSche sche);

	//����ճ�֮ǰ�Ȳ�ѯ���ݿ�����������ֵ
	public String getMaxIdoOfficePerSche();

	// �����ճ��б���ҳ��ѯ��
	public List<OOfficePerSche> getOPerAgendaList(OOfficePerSche oOfficePerSche);	
}