package com.prisys.web.service.impl;


import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.UnableToInterruptJobException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import com.prisys.quartz.utils.SpringJobModel;
import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.dao.SysJobDao;
import com.prisys.web.entity.SysJob;
import com.prisys.web.service.SchedulerService;
import com.prisys.web.utils.DateUtil;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService {

	
//	//调度器，任务调度的主API
//	@Autowired
	private Scheduler scheduler;
	@Resource
	private SysJobDao sysJobDao;
	
	
	@PostConstruct
	public void init() {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.startDelayed(60);
//			SchedulerFactory sf = new StdSchedulerFactory();
//			scheduler =sf.getScheduler();
			System.out.println("任务调度启动,延时1分钟后开始执行!");
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

	}
	//一个具体任务的设置，指定了要执行的任务和执行任务 的时间策略（用于定义任务的实例）
//	@Autowired
	private JobDetail jobDetail;
	private Trigger trigger;// 容器中任务调度器
	
	public void runBean(String beanName,String methodName) {
		try {
		jobDetail =newJob(SpringJobModel.class).withIdentity(UUID.randomUUID().toString(), "group1").build();
		jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_BEAN_NAME, beanName);
		jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_METHOD_NAME, methodName);
		// 复杂 的任务调度
		TriggerBuilder<CronTrigger> builder = newTrigger().withIdentity(UUID.randomUUID().toString(), jobDetail.getKey().getGroup())
				.withSchedule(cronSchedule("0/10 * * ? * * *"));
//		// 若有起始时间，则设置
//
//		if (CommonUtil.isNaN(jobDetail.getStarttime())) {
//			builder.startAt(DateUtil.string2date(jobDetail.getStarttime()));
//		}
//		// 设置终止时间
//		if (CommonUtil.isNaN(jobDetail.getEndtime())) {
//			builder.endAt(DateUtil.string2date(jobDetail.getEndtime()));
//		}
		trigger = builder.build();
			scheduler.scheduleJob(jobDetail, trigger);
//			scheduler.start();
//			scheduler.startDelayed(60);
//			try {
//			System.out.println("------- 等待5分钟  ... ------------");
//			Thread.sleep(300L * 1000L);
//		    } catch (Exception e) { }

//		scheduler.shutdown(true);
//			scheduler.deleteJob(new JobKey(name, group))
//		System.out.println("------- 调度已关闭 ---------------------");
		// 显示一下  已经执行的任务信息
		SchedulerMetaData metaData = scheduler.getMetaData();
		System.out.println("~~~~~~~~~~  执行了 " + metaData.getNumberOfJobsExecuted() + " 个 jobs.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runBean2(){
		try {
			    // 日期格式化
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");
				Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
				Date ft;
				// 将执行11次(执行1次,重复10次) ,每10秒重复一次
				jobDetail = newJob(SpringJobModel.class).withIdentity(UUID.randomUUID().toString(), "group1").build();
				jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_BEAN_NAME, "notBean");
				jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_METHOD_NAME, "pri");
				SimpleTrigger trigger = (SimpleTrigger)newTrigger()
								.withIdentity(jobDetail.getKey().getName(), jobDetail.getKey().getGroup())
								.startAt(startTime)
								.withSchedule(
										simpleSchedule()
										.withIntervalInSeconds(10)// 重复间隔
										.withRepeatCount(10))     // 重复次数
										.build();
				
					ft = scheduler.scheduleJob(jobDetail, trigger);
//					ft = scheduler.scheduleJob(jobDetail, trigger);
					System.out.println(jobDetail.getKey().getName()+ " 将在 : " + dateFormat.format(ft) + " 时运行.并且重复: "
							+ trigger.getRepeatCount() + " 次, 每次间隔 "
							+ trigger.getRepeatInterval() / 1000 + " 秒");
					scheduler.start();
					System.out.println("------- 开始调度 (调用.start()方法) ----------------");
					System.out.println("-------系统 启动 的 时间 :" + dateFormat.format(new Date()));
					

//					try {
//						System.out.println("------- 等待5分钟  ... ------------");
//						Thread.sleep(300L * 1000L);
//					} catch (Exception e) { }

//					scheduler.shutdown(true);
//					System.out.println("------- 调度已关闭 ---------------------");

					// 显示一下  已经执行的任务信息
//					SchedulerMetaData metaData = scheduler.getMetaData();
//					System.out.println("~~~~~~~~~~  执行了 " + metaData.getNumberOfJobsExecuted() + " 个 jobs.");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	public void run2(){
		try {
			// 日期格式化
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");
			
//			SchedulerFactory sf = new StdSchedulerFactory();
//			Scheduler sched = sf.getScheduler();
			System.out.println("--------------- 初始化 -------------------");

			// 下一个第15秒 例:
			//           当前 10秒,则 执行时间为15秒
			//           当前 16秒,则 执行时间为30秒
			//           当前 33秒,则 执行时间为45秒
			//           当前 48秒,则 执行时间为00秒
			Date startTime = DateBuilder.nextGivenSecondDate(null, 15);

			// job1 将只会执行一次 
//			jobDetail = newJob(SimpleJob.class).withIdentity("job1", "group1").build();
//			SimpleTrigger trigger = (SimpleTrigger) newTrigger()
//					.withIdentity("trigger1", "group1")
//					.startAt(startTime).build();
//			// 把job1 和 trigger加入计划   .  ft:此任务要执行的时间
			Date ft;
//			
//				ft = scheduler.scheduleJob(jobDetail, trigger);
//			System.out.println(jobDetail.getKey().getName() + " 将在 : " + dateFormat.format(ft) + " 时运行.并且重复: "
//					+ trigger.getRepeatCount() + " 次, 每次间隔 "
//					+ trigger.getRepeatInterval() / 1000 + " 秒");


			// 将执行11次(执行1次,重复10次) ,每10秒重复一次
						jobDetail = newJob(SpringJobModel.class).withIdentity(UUID.randomUUID().toString(), "group1").build();
						jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_BEAN_NAME, "notBean");
						jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_METHOD_NAME, "pri");
						SimpleTrigger trigger = (SimpleTrigger)newTrigger()
										.withIdentity(jobDetail.getKey().getName(), jobDetail.getKey().getGroup())
										.startAt(startTime)
										.withSchedule(
												simpleSchedule()
												.withIntervalInSeconds(10)// 重复间隔
												.withRepeatCount(10))     // 重复次数
												.build();
						ft = scheduler.scheduleJob(jobDetail, trigger);
						System.out.println(jobDetail.getKey().getName()+ " 将在 : " + dateFormat.format(ft) + " 时运行.并且重复: "
								+ trigger.getRepeatCount() + " 次, 每次间隔 "
								+ trigger.getRepeatInterval() / 1000 + " 秒");
			
			

			

		

			// 所有的任务都被加入到了 scheduler中 ,但只有 schedulers.start(); 时才开始执行
			scheduler.start();
			System.out.println("------- 开始调度 (调用.start()方法) ----------------");
			System.out.println("-------系统 启动 的 时间 :" + dateFormat.format(new Date()));
			
			try {
				System.out.println("------- 等待5分钟  ... ------------");
				Thread.sleep(300L * 1000L);
			} catch (Exception e) { }

			scheduler.shutdown(true);
			System.out.println("------- 调度已关闭 ---------------------");

			// 显示一下  已经执行的任务信息
			SchedulerMetaData metaData = scheduler.getMetaData();
			System.out.println("~~~~~~~~~~  执行了 " + metaData.getNumberOfJobsExecuted() + " 个 jobs.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	
	/**
	 * 运行
	 */
	@ServiceLog("运行定时任务")
	public void createRunJobByJobId(Long id) {
		try {
			SysJob sysJob=sysJobDao.selectByPrimaryKey(id);
			String name=sysJob.getJobName();
			boolean flag=true;
			if(name==null||sysJob.equals("")){
				flag=false;
			}else{
				flag=scheduler.checkExists(new JobKey(name, sysJob.getId()+""));
			}
			//不存在则执行
			if(!flag){
				name=UUID.randomUUID().toString();
				sysJob.setJobName(name);
				jobDetail =newJob(SpringJobModel.class).withIdentity(name, sysJob.getId()+"").build();
				jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_BEAN_NAME, sysJob.getBeanName());
				jobDetail.getJobDataMap().put(SpringJobModel.SRPTING_METHOD_NAME, sysJob.getMethodName());
				// 复杂 的任务调度
				TriggerBuilder<CronTrigger> builder = newTrigger().withIdentity(name, jobDetail.getKey().getGroup())
						.withSchedule(cronSchedule(sysJob.getExpression()));
				// 若有起始时间，则设置
		        String startTime=sysJob.getStarttime();
		        String endTime=sysJob.getEndtime();
				if (startTime!=null && !startTime.equals("")) {
					builder.startAt(DateUtil.stringToDate(startTime));
				}
				// 设置终止时间
				if (endTime!=null && !endTime.equals("")) {
					builder.endAt(DateUtil.stringToDate(endTime));
				}
				trigger = builder.build();
				scheduler.scheduleJob(jobDetail, trigger);
				//更新
				sysJob.setState(1);//已运行
			}else{
				//恢复Job任务开始执行
				scheduler.resumeJob(new JobKey(name, sysJob.getId()+""));
				sysJob.setState(1);//已运行
			}
			sysJobDao.updateByPrimaryKey(sysJob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 停止
	 */
	@Override
	@ServiceLog("停止定时任务")
	public void createStopJobByJobId(Long id) {
		SysJob sysJob=sysJobDao.selectByPrimaryKey(id);
		try {
			if(sysJob!=null){
				//暂停job
				scheduler.pauseJob(new JobKey(sysJob.getJobName(), sysJob.getId()+""));
			}
		} catch (UnableToInterruptJobException e) {
			e.printStackTrace();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		sysJob.setState(2);//已停止
		sysJobDao.updateByPrimaryKey(sysJob);
	}
	/**
	 * 删除
	 */
	@Override
	@ServiceLog("删除定时任务")
	public void deleteByPrimaryKey(Long id) {
		SysJob sysJob=sysJobDao.selectByPrimaryKey(id);
		if(sysJob!=null){
			//删除job
			try {
				boolean flag=true;
				String name=sysJob.getJobName();
				if(name==null||sysJob.equals("")){
					flag=false;
				}else{
					//判断是否存在
					flag=scheduler.checkExists(new JobKey(name, sysJob.getId()+""));
				}
				if(flag){
					scheduler.deleteJob(new JobKey(name, sysJob.getId()+""));
				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		sysJobDao.deleteSysJob(sysJob);
	}
}
