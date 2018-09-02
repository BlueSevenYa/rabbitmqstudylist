package com.shiqi.mapper;

import com.shiqi.entity.BrokerMessageLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by
 *
 * @author=蓝十七
 * @on 2018-09-01-23:27
 */
@Repository
public interface BrokerMessageLogMapper {

    int insertBML(BrokerMessageLog brokerMessageLog);

    List<BrokerMessageLog> query4StatusAndTimeoutMessage();

    void update4ReSend(@Param("messageId")String messageId, @Param("updateTime")Date updateTime);
    void changeBrokerMessageLogStatus(@Param("messageId") String messageId,
                                      @Param("status") String staus,
                                      @Param("updateTime") Date updateTime);
}
