package com.spring.mapper;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
	
	int check_admin(Map<String, Object> param);
	/*	 
     *   <p>銆愭樉绀哄弻閫夎〃涓鐢熻�佸笀銆�</p>
     *
     * @author  鏇惧浆鍒� 
     *
     * @param param
     * @return
     * 
     */
	List<Map<String, Object>> showStudentAndTeacher(Map<String, Object> param);
	/*	 
	 *   <p>銆愭樉绀哄弻閫夎〃涓煇鑰佸笀瀵瑰簲鐨勫鐢熴��</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 * select * FROM TS 
	 * where tno = #{tno}
	 */
	List<Map<String, Object>> showStudentByTeacher(Map<String, Object> param);
	/*	 
	 *   <p>銆愭樉绀烘墍鏈夊鐢熷織鎰裤��</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 * 
	 */
	List<Map<String, Object>> selectAllRound(Map<String, Object> param);
	/*	 
	 *   <p>銆愭樉绀烘墍鏈夊鐢熸寜缁╃偣闄嶅簭銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> showStudentAllDesc(Map<String, Object> param);
	/*	 
	 *   <p>銆愭樉绀烘墍鏈夌鐞嗗憳銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> showAdminAll(Map<String, Object> param);
	/*	 
	 *   <p>銆愭樉绀轰竴涓鐞嗗憳銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	Map<String, Object> showAdminInfo(Map<String, Object> param);
	/*	 
	 *   <p>銆愭樉绀哄織鎰裤��</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	 Map<String, Object> selectRound(Map<String, Object> param);
	
	/*	 
	 *   <p>銆愭樉绀轰竴涓弻閫夎〃淇℃伅銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	Map<String, Object> showStudentAndTeacherOneById(Map<String, Object> param);
	/*	 
	 *   <p>銆愭煡璇㈡病鏈夎瀵煎笀閫夋嫨鐨勫鐢熶俊鎭��</p>
	 *
	 * @author  宕旂帀榫� 
	 *
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> showStudentNotSelected(Map<String, Object> param);
	
	/*
	 * <p>銆愬湪鑰佸笀鐨勫弻閫夌晫闈腑鏄剧ず瀛︾敓淇℃伅銆�</p>
	 * 
	 * 
	 * */
	List<Map<String,Object>> selectRoundByTeacher(Map<String, Object> param);
	
	/**
	 * 2018-11-8修改
	 * @param param
	 */
	/**
	 * 第一轮志愿
	 * @param param
	 * @return
	 */
	List<Map<String,Object>> selectRoundByTeacherR1(Map<String, Object> param);
	/**
	 * 第二轮志愿
	 * @param param
	 * @return
	 */
	List<Map<String,Object>> selectRoundByTeacherR2(Map<String, Object> param);
	/**
	 * 第三轮志愿
	 * @param param
	 * @return
	 */
	List<Map<String,Object>> selectRoundByTeacherR3(Map<String, Object> param);
	/**
	 * 第四轮志愿
	 * @param param
	 * @return
	 */
	List<Map<String,Object>> selectRoundByTeacherR4(Map<String, Object> param);
	
	
	/*	 
	 *   <p>銆愪慨鏀圭鐞嗗憳銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void updateAdmin(Map<String, Object> param);
	/*	 
	 *   <p>銆愪慨鏀瑰弻閫夎〃銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void updateTS(Map<String, Object> param);
	   /*  
     *   <p>銆愬垹闄ゅ弻閫夎〃淇℃伅銆�</p>
     *
     * @author  鏇惧浆鍒� 
     *
     * @param param
     * @return
     */
    void deleteTSById(Map<String, Object> param);
	/*	 
	 *   <p>銆愬垹闄ょ鐞嗗憳銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void deleteAdminById(Map<String, Object> param);
	/*	 
	 *   <p>銆愭柊澧炵鐞嗗憳銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void addAdmin(Map<String, Object> param);
	/*	 
	 *   <p>銆恆ddAdmin鐨勮緟鍔╂煡璇€��</p>
	 *
	 * @author  宕旂帀榫�
	 *
	 * @param param
	 * @return
	 */
	int exsitAdmin(Map<String, Object> param);
	/*	 
	 *   <p>銆愭柊澧炲弻閫夎〃銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void AinsertTS(Map<String, Object> param);
	
	/*
	 * 
	 * <p> 銆愭煡璇S琛ㄧ湅鏄惁鏈変负绌虹殑杩斿洖鍊笺�� </p>
	 * 
	 */
	
	Map<String, Object> checkSomeTS(Map<String, Object> ts);
	
	/*	 
	 *   <p>銆愭暀甯堥�夋嫨瀛︾敓銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void TselectTS(Map<String, Object> param);
	
	/*	 
	 *   <p>銆愭洿鏂版暀甯堣〃涓殑num瀛楁鐨勫��(-1/+1)銆�</p>
	 *
	 * @author  宕旂帀榫�
	 *
	 * @param param
	 * @return
	 */
	void UpdateTeacherCanSelectNum(Map<String, Object> param);
	
	
	/*
	 * <p> 銆愭暀甯堝垹闄ら�夋嫨鐨勫鐢熴��  </p>
	 * @author  宕旂帀榫�
	 * 
	 */
	void TdeleteTS(Map<String, Object> param);
	
	/*	 
	 *   <p>銆愭彃鍏ound琛ㄣ��</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void insertRound(Map<String, Object> param);
	
	/*	 
	 *   <p>銆愭彃鍏ound琛ㄣ��</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void updateRound(Map<String, Object> param);
	/*	 
	 *   <p>銆愭柊澧炴椂闂磋〃銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void insertCtime(Map<String, Object> param);
	/*	 
	 *   <p>銆愪慨鏀规椂闂磋〃銆�</p>
	 *
	 * @author  鏇惧浆鍒� 
	 *
	 * @param param
	 * @return
	 */
	void updateCtime(Map<String, Object> param);
	/*  
     *   <p>銆愭樉绀烘椂闂磋〃銆�</p>
     *
     * @author  鏇惧浆鍒� 
     *
     * @param param
     * @return
     */
    Map<String, Object> showCtime(Map<String, Object> param);
    /*  
     *   <p>銆愭牎楠屾椂闂磋〃銆�</p>
     *
     * @author  鏇惧浆鍒� 
     *
     * @param param
     * @return
     */
    int  checkCtime(Map<String, Object> param);
    /*  
     *   <p>銆愯幏鍙栨暀甯堝凡閫変汉鏁般��</p>
     *
     * @author  鏇惧浆鍒� 
     *
     * @param param
     * @return
     */
    int  checkTS(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊鏁欏笀鐨勭爺绌舵柟鍚戜俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void A_update_direction(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊鏁欏笀鐨勭爺绌舵垚鏋滀俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void A_update_achievement(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊鏁欏笀鐨勬暀瀛︾鐩俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void A_update_teach(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊鏁欏笀鐨勭爺绌剁畝浠嬩俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void A_update_researchAbstract(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊鏁欏笀鐨勭収鐗囦俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void A_update_T_picture(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊瀛︾敓鐨勭収鐗囦俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void A_update_S_picture(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊鏁欏笀鐨勫叾浠栦俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void updateTeacherByAdmin(Map<String, Object> param);
    /*  
     *   <p>銆愮鐞嗗憳鏇存柊瀛︾敓鐨勫叾浠栦俊鎭��</p>
     *
     * @author  宕旂帀榫�
     *
     * @param param
     * @return
     */
    void updateStudentByAdmin(Map<String, Object> param);

    void update_lowGPA(int grade);
    /*
     *  将绩点后20名学生在数据库中标记（lowGPA）
     */
	List<Map<String, Object>> getRoundTeacher(int grade);
	/*
	 * 获取第N轮被选择的所有教师
	 */
	int getTeacherNum(String tid);
	/*
	 * 获取教师剩余可选数量
	 */
	int getStudentNum(Map<String,Object> map);
	/*
	 * 获取第一轮选择该教师学生总数
	 */
	int getStudentNum2(Map<String,Object> map);
	/*
	 * 获取第2轮选择该教师学生总数
	 */
	int getStudentNum3(Map<String,Object> map);
	/*
	 * 获取第3轮选择该教师学生总数
	 */
	int getStudentNum4(Map<String,Object> map);
	/*
	 * 获取第4轮选择该教师学生总数
	 */
	List<Map<String, Object>> getStudentId_round1(Map<String,Object> map);
	/*
	 * 获取第一轮选中该教师的学生ID
	 */
	int getlowGPA_ts(Map<String, Object> tmap);
	/*
	 * 获取教师已选中的带*学生数量
	 */
	int getlowGPA_select1(Map<String, Object> tmap);
	/*
	 * 获取第一轮选择该教师带*学生数量
	 */
	String getlowGPA_sid1(Map<String, Object> map);
	/*
	 * 获取第一轮选择该教师带*学生ID
	 */
	List<Map<String, Object>> getRoundTeacher2(int grade);
	/*
	 * 获取第2轮被选择的所有教师
	 */
	List<Map<String, Object>> getRoundTeacher3(int grade);
	/*
	 * 获取第3轮被选择的所有教师
	 */
	List<Map<String, Object>> getRoundTeacher4(int grade);
	/*
	 * 获取第4轮被选择的所有教师
	 */
	List<Map<String, Object>> getStudentId_round2(Map<String, Object> tmap);
	/*
	 * 获取第2轮选中该教师的学生ID
	 */
	List<Map<String, Object>> getStudentId_round3(Map<String, Object> tmap);
	/*
	 * 获取第3轮选中该教师的学生ID
	 */
	List<Map<String, Object>> getStudentId_round4(Map<String, Object> tmap);
	/*
	 * 获取第4轮选中该教师的学生ID
	 */
	int getlowGPA_select2(Map<String, Object> tmap);
	/*
	 * 获取第2轮选择该教师带*学生数量
	 */
	int getlowGPA_select3(Map<String, Object> tmap);
	/*
	 * 获取第3轮选择该教师带*学生数量
	 */
	int getlowGPA_select4(Map<String, Object> tmap);
	/*
	 * 获取第4轮选择该教师带*学生数量
	 */
	String getlowGPA_sid2(Map<String, Object> tmap);
	/*
	 * 获取第2轮选择该教师带*学生ID
	 */
	String getlowGPA_sid3(Map<String, Object> tmap);
	/*
	 * 获取第3轮选择该教师带*学生ID
	 */
	String getlowGPA_sid4(Map<String, Object> tmap);
	/*
	 * 获取第4轮选择该教师带*学生ID
	 */
	List<Map<String, Object>> getStudentGrade();
	/*
	 * 获取当前数据库中学生年级
	 */
	List<Map<String, Object>> ts_Teacher();
	/*
	 * 获取双选信息表中教师ID
	 */
}
