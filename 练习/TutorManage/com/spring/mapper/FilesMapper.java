package com.spring.mapper;

import java.util.Map;

public interface FilesMapper {

    /*   
     *   <p>【根据sno显示文档】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    Map<String, Object> showFiles(Map<String, Object> param);
	 /*   
     *   <p>【更新文档】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void updateFiles(Map<String, Object> param);
    /*   
     *   <p>【新增一条文档记录】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    void addFilesRecord(Map<String, Object> param);
    /*   
     *   <p>【删除一条文档记录】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    void deleteFilesRecord(Map<String, Object> param);
    /*   
     *   <p>【新增文档】</p>
     *
     * @author  曾彬利
     *
     * @param param
     * @return
     */
    void addFiles(Map<String, Object> param);
    /*   
     *   <p>【删除文档】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */   
    void deleteFiles(Map<String, Object> param);  
    
    
    
    /*   
     *   <p>【根据sno显示模板】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    Map<String, Object> showTemplate(Map<String, Object> param);
     /*   
     *   <p>【更新模板】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void updateTemplate(Map<String, Object> param);
    /*   
     *   <p>【新增模板】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void addTemplate(Map<String, Object> param);
    
}
