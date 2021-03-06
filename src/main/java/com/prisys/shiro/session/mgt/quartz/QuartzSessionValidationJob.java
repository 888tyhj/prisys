/*
 * 文件名：QuartzSessionValidationJob.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月17日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.shiro.session.mgt.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.shiro.session.mgt.ValidatingSessionManager;

/**
 * A quartz job that basically just calls the {@link org.apache.shiro.session.mgt.ValidatingSessionManager#validateSessions()}
 * method on a configured session manager.  The session manager will automatically be injected by the
 * superclass if it is in the job data map or the scheduler map.
 *
 * @since 0.1
 */
public class QuartzSessionValidationJob implements Job {

    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    /**
     * Key used to store the session manager in the job data map for this job.
     */
    static final String SESSION_MANAGER_KEY = "sessionManager";

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/
    private static final Logger log = LoggerFactory.getLogger(QuartzSessionValidationJob.class);

    /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/

    /*--------------------------------------------
    |               M E T H O D S               |
    ============================================*/

    /**
     * Called when the job is executed by quartz.  This method delegates to the
     * <tt>validateSessions()</tt> method on the associated session manager.
     *
     * @param context the Quartz job execution context for this execution.
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap jobDataMap = context.getMergedJobDataMap();
        ValidatingSessionManager sessionManager = (ValidatingSessionManager) jobDataMap.get(SESSION_MANAGER_KEY);

        if (log.isDebugEnabled()) {
            log.debug("Executing session validation Quartz job...");
        }

        sessionManager.validateSessions();

        if (log.isDebugEnabled()) {
            log.debug("Session validation Quartz job complete.");
        }
    }
}

