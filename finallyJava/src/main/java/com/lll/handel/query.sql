-- ////////////////////////取数据sql/////////////////////////////////

ITG_OTH_CDR_H	移动语音详单
CFEE 基本通话费
CHARGING_DURATION 计费时长
PROV_ID 省份编码
CALL_DURATION 通话时长
MSISDN 计费号码


set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select 	CFEE,CHARGING_DURATION,CALL_DURATION
from net_db.ITG_OTH_CDR_H
where PROV_ID=811
limit 1000


set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select 	MSISDN,	OTHER_PARTY,THIRD_PARTY
from bil_db.ITG_OTH_CDR_H
where PROV_ID="811" and LENGTH(MSISDN)=11
limit 1000

PROV_ID="811" and LENGTH(MSISDN)=11.xsl


set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select 	FILE_NAME,MSISDN,OTHER_PARTY,CALL_DURATION,CFEE,EVENT_TYPE,CDR_KEY,
CHARGING_DURATION,DAY_ID,HOUR_ID
from bil_db.ITG_OTH_CDR_H
where PROV_ID="811" and substr(DAY_ID,1,6)=201709
limit 100

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select BIZ_TYPE,CALL_TYPE,ROAM_TYPE,
DAY_ID,HOUR_ID,
MSISDN,OTHER_PARTY,CALL_DURATION
from bil_db.ITG_OTH_CDR_H
where PROV_ID="811" and substr(DAY_ID,1,6)=201709
limit 100

EVENT_TYPE ,CDR_KEY,
CHARGING_DURATION

BIZ_TYPE,CALL_TYPE,ROAM_TYPE,
DAY_ID,HOUR_ID,
MSISDN,OTHER_PARTY,CALL_DURATION





15311531188
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select 	sum(CALL_DURATION)as "total call"
from bil_db.ITG_OTH_CDR_H
where MSISDN=15311531188 and substr(DAY_ID,1,6)=201709

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
create table temp.db(
phone_num string;
prod_id string
)row format delimited fields terminated by '\t';


set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select
sum(case when call_duration is null then 0 else call_duration end)as"total_call"
from bil_db.ITG_OTH_CDR_H
where MSISDN=15311531188 and substr(DAY_ID,1,6)=201709


-- 这个可以，嘿嘿
-- 一个号码，一个月的总通话时长
set tez.queue.name=root.sjzl.sjzl_yexin1;
select
sum(case when call_duration is null then 0 else call_duration end) call_duration
from bil_db.ITG_OTH_CDR_H
where MSISDN=15311531188 and substr(DAY_ID,1,6)=201709 and PROV_ID="811"

--这是八个属性
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select BIZ_TYPE,CALL_TYPE,ROAM_TYPE,
DAY_ID,HOUR_ID,
MSISDN,OTHER_PARTY,CALL_DURATION
from bil_db.ITG_OTH_CDR_H
where PROV_ID="811" and substr(DAY_ID,1,6)=201709
limit 100

--建中间表

create table ctsi_test01.tempGetData_db(
phone_num string,
call_time string
)row format delimited fields terminated by '\t';



--10000个手机号导入到 tempGetData_db
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select MSISDN,BIZ_TYPE
from bil_db.ITG_OTH_CDR_H
where PROV_ID="811" and substr(DAY_ID,1,6)=201709
limit 10000


insert into table ctsi_test01.tempGetData_db
select MSISDN,BIZ_TYPE
from bil_db.ITG_OTH_CDR_H
where PROV_ID="811" and substr(DAY_ID,1,6)=201709
limit 10000

--将10000个手机号 北京的 9月的 通话时长记录下来

select a.MSISDN,a.CALL_DURATION FROM (
SELECT MSISDN,sum(case when call_duration is null then 0 else call_duration end) call_duration
FROM bil_db.ITG_OTH_CDR_H
where substr(DAY_ID,1,6)=201709 and PROV_ID=811
left join
(select phone_num from tempGetData_db)b
on bil_db.ITG_OTH_CDR_H.MSISDN=b.phone_num
)

SELECT
MSISDN,sum(case when call_duration is null then 0 else call_duration end) call_duration
FROM
bil_db.ITG_OTH_CDR_H
LEFT JOIN ctsi_test01.tempGetData_db
ON bil_db.ITG_OTH_CDR_H.MSISDN=
ctsi_test01.tempGetData_db.phone_num


WHERE
PROV_ID="811" and substr(prov_id,1,6)=201709

-- ////////////////////////////////////////////////////////////////////

select
a.prov_id as `省ID`,
count(*) as `销售员总数`,
sum(case when b.staff_code is not null then 1 else 0 end) as `关联成功销售员数量`,
round(sum(case when b.staff_code is not null then 1 else 0 end)/count(*)*100.00,2) as `关联成功率`
from

(select *
from bil_db.itg_tpss_settle_detail_m
where month_id=201708
and developing_person_code is not null
and trim(developing_person_code)!=''
and upper(developing_person_code)!='NULL') as a

left join

(select
staff_code
from hqpf_db.itf_chnl_staff_info_d
where day_id=20171011
and staff_code is not null
and trim(staff_code)!=''
and upper(staff_code)!='NULL'
group by staff_code
) as b

on a.developing_person_code=b.staff_code

group by a.prov_id



--通过级联下面俩个电话号码表来求appname的数据。
create table ctsi_test01.tlll_814(
acc_num string,
act_date string
)row format delimited fields terminated by ',';

load data inpath 'hdfs://ns2/tmp/814outdata_1.txt' into table tlll_814;


create table ctsi_test01.tlll_835(
acc_num string,
act_date string
)row format delimited fields terminated by ',';

load data inpath 'hdfs://ns2/tmp/835outdata_1.csv' into table tlll_835;

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select chk_tel,name48,appname
from net_db.itg_4gdpi_comm_h
where op_time = 20171101 and appname like"新闻"
limit 50
--这个能得到最后的

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select count(*) as numn
distinct chk_tel
from net_db.itg_4gdpi_comm_h
where  prov_id=814 and substr(op_time,1,6)=201709

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select chk_tel,appname,name48,msisdn
from net_db.itg_4gdpi_comm_h
where  prov_id=814 and substr(op_time,1,6)=201710
group by chk_tel;


--通过级联下面俩个电话号码表来求appname的数据。
-- 这俩个是存在ctsi_test01中的表，可以级联
create table ctsi_test01.tlll_814(
acc_num string,
act_date string
)row format delimited fields terminated by ',';
load data inpath 'hdfs://ns2/tmp/814outdata_1.txt' into table tlll_814;
create table ctsi_test01.tlll_835(
acc_num string,
act_date string
)row format delimited fields terminated by ',';
load data inpath 'hdfs://ns2/tmp/835outdata_1.csv' into table tlll_835;
-- 这个是外卖appname的对照
create table ctsi_test01.idlll_appname(
appname string,
id int
)row format delimited fields terminated by ',';
load data inpath 'hdfs://ns2/tmp/id1121.csv' into table idlll_appname;



-- msisdn和chk_tel是一样的，都是电话号码
-- 然后appname很多空的，没用
-- 814_10.csv  1g
select chk_tel,appname,name48,msisdn
from net_db.itg_4gdpi_comm_h
where  prov_id=814 and substr(op_time,1,6)=201710

-- 这个是用来统计一个月的 ，基本上是山西省的电话号码总是
-- 可惜答案还没出来
-- 2182065
select count(distinct chk_tel)
from net_db.itg_4gdpi_comm_h
where substr(op_time,1,6) = 201710 and prov_id=814

-- 这个是非空的appname
-- 814_appname_10month.csv  1g
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select chk_tel,appname,name48
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and substr(op_time,1,6)=201710
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'

****
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,chk_time,terminaltype,terminalbrand,terminalmodel
from net_db.itg_4gdpi_comm_h
where  prov_id=835
  and substr(op_time,1,6)=201711
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'

-- 记录山西 ，十月每一天的appname非空
-- 814_1030_appnameisnotnull.csv
-- 记录了十天的  20-30
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and op_time=20171029
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'


这个是记录三大外卖的是用次数
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,count(appname) as count_all
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and  op_time=20171010
  and (appname='饿了么' or appname='美团外卖' or appname='百度外卖')


select chk_tel,
sum(case when appname='美团外卖' then 1 else 0 end) as a1,
sum(case when appname='饿了么' then 1 else 0 end) as a2,
sum(case when appname='百度外卖' then 1 else 0 end) as a3
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and substr(op_time,1,6)=201710
group by chk_tel;


select msisdn,
count(case when appname='美团外卖' then 1 else 0 end) as a1,
count(case when appname='饿了么' then 1 else 0 end) as a2,
count(case when appname='百度外卖' then 1 else 0 end) as a3
from net_db.itg_4gdpi_comm_h
where  prov_id=811
  and op_time=20171020
group by msisdn;

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and op_time=20171020
  and appname like '%外卖%'

--太少，就几条，不知道为什么。。。
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,count(appname) as cc
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and op_time=20171030
  and (appname ='饿了么' or appname='美团外卖' or appname='百度外卖')

-- 811_1029_3waimai_notcount.csv
-- 811_1030_3waimai_notcount.csv
--北京 一天 三大外卖 很多很好 还是北京用的人多。
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname
from net_db.itg_4gdpi_comm_h
where  prov_id=811
  and op_time=20171029
  and (appname ='饿了么' or appname='美团外卖' or appname='百度外卖')


--811_1101_3waimai_count.csv
--减了一下，count非零的大概有12w对条，一共是200多w条。
select msisdn,
sum(case when appname='美团外卖' then 1 else 0 end) as a1,
sum(case when appname='饿了么' then 1 else 0 end) as a2,
sum(case when appname='百度外卖' then 1 else 0 end) as a3
from net_db.itg_4gdpi_comm_h
where  prov_id=811
  and op_time=20171101
group by msisdn;
--直接上一个月的，嘿嘿
--811_10m_3waimai_count.csv
select msisdn,
sum(case when appname='美团外卖' then 1 else 0 end) as a1,
sum(case when appname='饿了么' then 1 else 0 end) as a2,
sum(case when appname='百度外卖' then 1 else 0 end) as a3
from net_db.itg_4gdpi_comm_h
where  prov_id=811
  and substr(op_time,1,6) = 201710
group by msisdn;


-- status_cd 状态  记录状态
-- cust_status_cd 客户状态  记录客户生命周期状态，如潜在、在网、离网。
select  cust_id,STATUS_CD,CUST_STATUS_CD
from crm_db.ITG_CUSTOMER_D
where prov_id=814
limit 1000

-- PROD_INST_ID 产品实例标识
-- PROD_ID 产品标识
select  PROD_ID,PROD_INST_ID
from crm_db.ITG_PROD_INST_D
where prov_id=814
limit 1000


BIZ_TYPE 业务类型， 01国内02国际
call_type 呼叫类型，01：主叫，02：被叫，03：呼转
ROAM_TYPE 漫游类型  0:非漫游, 1:省内漫游,4:省际出访漫游, 5: 国际漫游
LONG_TYPE 长途类型 http://training.cndata.com:8090/pages/viewpage.action?pageId=2950720
BILLING_MODE 付费模式

MSISDN 计费号码
CALL_DURATION 通话时长
CFEE 基本通话费 分

->>移动语音详单 一天 山西省 sum(通话时长) 的表
call_type,BIZ_TYPE,ROAM_TYPE,LONG_TYPE,BILLING_MODE,
select MSISDN,
sum(CALL_DURATION) as all_duration,CFEE
from bil_db.ITG_OTH_CDR_H
where prov_id=814
and day_id=20170901
group by msisdn

-- 0901语音详单
select MSISDN,call_type,BIZ_TYPE,ROAM_TYPE,LONG_TYPE,BILLING_MODE,CALL_DURATION,CFEE
from bil_db.ITG_OTH_CDR_H
where prov_id=814
and day_id=20170901
group by msisdn
--0901_sum(call_duration).csv
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select MSISDN,
sum(CALL_DURATION) as all_duration
from bil_db.ITG_OTH_CDR_H
where prov_id=814
and day_id=20170901
group by msisdn

-- 0901语音详单
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select MSISDN,call_type,BIZ_TYPE,ROAM_TYPE,LONG_TYPE,BILLING_MODE,CALL_DURATION,CFEE
from bil_db.ITG_OTH_CDR_H
where prov_id=814
and day_id=20170902
group by msisdn
--0901_sum(call_duration).csv
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select MSISDN,
sum(CALL_DURATION) as all_duration
from bil_db.ITG_OTH_CDR_H
where prov_id=814
and day_id=20170902
group by msisdn

--8/9/10/11/month_sum_duration
--只有俩个字段，这个比较烦。
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select MSISDN,
sum(CALL_DURATION) as Duration
from bil_db.ITG_OTH_CDR_H
where prov_id=814
and substr(day_id,1,6)=201711
group by msisdn









--用户兴趣细分appname
msisdn
appname
chk_time 开始时间
terminaltype 终端类型
terminalbrand 终端品牌
terminalmodel 终端型号

-- 814_1130_appname_notnull.csv
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,chk_time,terminaltype,terminalbrand,terminalmodel
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and op_time=20171130
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'

-- 814_appname_11month
-- 这个很重要的，主要是因为这是一个月的所有的appname的调查情况
-- 又没有到达1G，字段也比较多，可以好好分析
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,chk_time,terminaltype,terminalbrand,terminalmodel
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and substr(op_time,1,6)=201711
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'

set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,chk_time,terminaltype,terminalbrand,terminalmodel
from net_db.itg_4gdpi_comm_h
where  prov_id=835
  and substr(op_time,1,6)=201711
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'


set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,chk_time,terminaltype,terminalbrand,terminalmodel
from net_db.itg_4gdpi_comm_h
where  prov_id=814
  and substr(op_time,1,6)=201711
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'
  and msisdn=13303408920


--对应情况查询

ITG_CUSTOMER_D

CUST_ID  主键，属主
-- CUST_ADDR 记录客户地址
CUST_AREA_GRADE 记录客户归属区域级别，包括集团客户、跨省客户、省内客户。LOVB。
CUST_AREA_GRADE_PROV 记录客户归属区域级别，包括集团客户、跨省客户、省内客户
-- CUST_NAME 记录客户名称。
CUST_STATUS_CD 记录客户生命周期状态，如潜在、在网、离网。LOVB。
CUST_TYPE 记录客户战略分群，如：政企、家庭、个人。LOVB。
CUST_TYPE_PROV 记录客户战略分群，如：政企、家庭、个人。
ENTER_DATE 记录入网时间。
IS_REALNAME 实名认证标识，记录该客户是否已经实名认证通过。实名认证的规则由应用实现。
PROV_ID
DAY_ID

--customer_814_1130.csv
select  cust_id,CUST_AREA_GRADE,CUST_AREA_GRADE_PROV,
CUST_STATUS_CD,CUST_TYPE,CUST_TYPE_PROV,
ENTER_DATE,IS_REALNAME
from crm_db.ITG_CUSTOMER_D
where prov_id=814
      and DAY_ID=20171130

select  cust_id,CUST_ADDR,CUST_AREA_GRADE,CUST_AREA_GRADE_PROV,
CUST_NAME,CUST_STATUS_CD,CUST_TYPE,CUST_TYPE_PROV,
ENTER_DATE,IS_REALNAME
from crm_db.ITG_CUSTOMER_D
where prov_id=814
      and substr(DAY_ID,1,6)=201709


-- 814_09_月账单.csv
select  MSISDN,CHARGE
from bil_db.ITG_OTH_MBI_M
where prov_id=814
      and MONTH_ID=201709
-- 814_08_月账单.csv
select  MSISDN,CHARGE
from bil_db.ITG_OTH_MBI_M
where prov_id=814
      and MONTH_ID=201708


set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select msisdn,appname,chk_time,terminaltype,terminalbrand,terminalmodel
from net_db.itg_4gdpi_comm_h
where  prov_id=835
  and substr(op_time,1,6)=201711
  and appname is not null
  and trim(appname)!=''
  and upper(appname)!='NULL'














-- ITG_OTH_CDR_H
-- SERV_ID 用户标识
-- MSISDN
--
-- 计费表 serv_id msisdn
-- 产品实例表 USE_CUST_ID PROD_INST_ID
-- 客户表 cust_id


-- PROD_INST_ID 产品实例标识
-- PROD_ID 产品标识
-- FIRST_FINISH_DATE 首次竣工时间
select  USE_CUST_ID,PROD_INST_ID,FIRST_FINISH_DATE
from crm_db.ITG_PROD_INST_D
where prov_id=814
      and substr(DAY_ID,1,6)=201708
limit 1000


select  cust_id,CUST_AREA_GRADE,CUST_AREA_GRADE_PROV,
CUST_STATUS_CD,CUST_TYPE,CUST_TYPE_PROV,
ENTER_DATE,IS_REALNAME
from crm_db.ITG_CUSTOMER_D
where prov_id=814
      and substr(DAY_ID,1,6)=201708
limit 1000

select MSISDN,SERV_ID,
from bil_db.ITG_OTH_CDR_H
where PROV_ID=814
      and substr(DAY_ID,1,6)=201708
limit 1000

--query_result.csv
--814_1101_customer.csv
select  cust_id,CUST_AREA_GRADE,CUST_AREA_GRADE_PROV,
CUST_STATUS_CD,CUST_TYPE,CUST_TYPE_PROV,
ENTER_DATE,IS_REALNAME
from crm_db.ITG_CUSTOMER_D
where prov_id=814
      and DAY_ID=20171101

-- query_result (1).csv
-- 814_1101_acc_aum_cust_id.csv
set mapreduce.job.queuename=root.sjzl.sjzl_yexin1;
set tez.queue.name=root.sjzl.sjzl_yexin1;
set hive.execution.engine=mr;
set hive.mapred.mode=nonstrict;
select  USE_CUST_ID,ACC_NUM
from crm_db.ITG_PROD_INST_D
where prov_id=814
    and DAY_ID=20171101

