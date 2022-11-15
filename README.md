-- Manual Charges
select * from ManualChargesDetail
select * from AdditionalCharges
select * from FNGL_Transactions_HI

[CoreDb].[dbo].[SMAM_CompanyCharges_ST]

-- SIF
select * from HRPR_ExportSIFFiles_HI
select * from AdditionalCharges
select * from FNGL_Transactions_HI

-- Cashload
select * from PCMS_Cashload_Master
select * from AdditionalCharges
select * from FNGL_Transactions_HI


SIF > paf > cashload


==================================================
When Add/Edit Employee API hit:

[CoreDb].[dbo].[SMAM_CompanyProducts_ST]
[CoreDb].[dbo].[SMAM_CompanyMst_ST]
[CoreDb].[dbo].[SMAM_CompanyEst_HI]
===================================================
For salary testing:
4 table entry:
Export SIF file
Export sif detail
WPS DB > Sif master, Sif Detail, PAF Master and PAF Detail 

Entry in all 4 tables

HRPR_ExportSIFFiles_HI filename should be in SELECT *
FROM WPSFileProcessing.dbo.SifMaster as coreDbreference

PAFMaster
PAF Detail in WPS processing DB

there is one column in sifMaster with the name of PafrefId
tghrough you can relate sifMaster with Pasf

=======================Eligibility of wallet ID===========================


==============advanced salary using Web Portal=============
select * from AdvanceSalary  -- shows current status
select *  from AdvanceSalaryDetail
select * from AdvanceSalaryStatustracking   --shows previous status
select * from AdvanceSalaryHeader

DEBIT = what we receive
Credit = what we give
Transaction refernece no is incremental

select
	PayrollDate as SalaryDate, t1.Month as SalaryMonth, t1.Year as SalaryYear,
	
	t2.NetAmount as SalaryAmount, t2.EmpPersonalNumber
	from
	WPSFileProcessing.dbo.PAFMaster as t1
	join WPSFileProcessing.dbo.PAFDetail as t2 on t1.Id = t2.PAFMasterId
where t2.EmpPersonalNumber = '10001078949383'
white_check_mark
eyes
raised_hands
React
Reply

3:54
--update WPSFileProcessing.dbo.PAFMaster
	--set PayrollDate = '2022-08-05'
	--where Id = 1


Advanced salary eligibility amount = 

30% of:

-last salary OR average salary of last 3 months
(whichever is lower)


=============/Employee/GetEmployeeBalance API=============

employee table customer ID employee master table
linked with coreDBEngine Accounts table by CustomerID 


=====================Deposit Slip and Balance Update API======================

20.203.21.188
Waqas
Waqas@123456
FNGL_Transactions_HI
HRPR_DepositSlip_TR
D:/Web Portal Publish/WebApi/KP_Portal_Files/UAT
00 - Portal\KPE20220094\Deposit Slips\Deposit Slips_KPE20220094_20221031120742.png


============================Add/Edit Exchange House========
ExchangeHouse Table


==========================Employee/UpdateEmpMolEstID============
[CoreDb].[dbo].[SMAM_CompanyEst_HI]
CoreDb.dbo.EmployeeEstablishmentLinking   //entry should be present in this table
HRMS_EmployeeMst_ST

=============================Employee/GetEmployeeStatusDetail========

============================exchangehouse/AddEditExchangeHouseBranch===

[dbo].[ExchangeHouse]

[dbo].[ExchangeHouseBranch]

====================================================================
ADD EDITEmployee

select * from HRMS_EMPGUID_NEW
select * from HRMS_EmployeeMst_ST 
select * from EmployeeEstablishmentLinking 
select * from SMAM_CompanyEst_HI on behalf of establishmendid
select * from HRMS_EmpDocs_ST
select * from CifEmployeeLinkings
select * from CifMaster


Centiv pe MOL waghaira ki koi restriction nhi
Payd pe MOL should be 13 or 14 digits(im not sure whether its 13 or 14)
===========================Add/EditEmployer====================================

Employer
SMAM_CompanyMst_ST
SMAM_CompanyProducts_ST
SMAM_CompanyDocs_ST
CifMaster	:no  changes
CifCompanyLinkings	:no changes
SMAM_CompanyEst_HI	:no changes


======================Add Edit Employee======================
Employee

select * from HRMS_EMPGUID_NEW
select * from HRMS_EmployeeMst_ST 
select * from EmployeeEstablishmentLinking 
select * from SMAM_CompanyEst_HI on behalf of establishmendid
select * from HRMS_EmpDocs_ST
select * from CifEmployeeLinkings
select * from CifMaster


=====================Upload Salary SIF File==================

select * from HRPR_ExportSIFFiles_HI order by 1 desc
select * from HRPR_ExpSifDetail_TR order by 1 desc
select WalletId,* from CoreDbEngine.dbo.FNGL_Accounts_TR where CustomerId = employee ki Cutomer Id
select * from HRMS_EmployeeMst_ST


===================Change Card Status API==================

SELECT * FROM CoreDbEngine.dbo.SRCC_CardStatusChange_TR A ORDER BY A.CardStatusId desc

SELECT * FROM  CoreDbEngine.dbo.SRCC_StatusChangeResponse_HI A ORDER BY A.ResponeOn desc
[CoreDbEngine].[dbo].[FNGL_Accounts_CardDetails]
SELECT * FROM CoreDb.dbo.HRMS_CardActions_TR A ORDER BY A.CreatedOn DESC

 A= active not embossed
 Y= temporary block		
 X = permanent block

account id:7, 417

Check IsRequested Key. IsRequested Key = 1 means requested from NI.
And IsRequested Key = Null = developer environment


===========================Card Activate API===============
Values in SRCC_CardActivation_TR table

==========================salary file process=============

salary file > SIF > Ack > PAF > DIF

=============================================================

MTP> Manual Transaction Posting, File created, sent to NI, 

Request Mobile API se banay gi
Process: Eligibility criteria, node js se hit aye gi mobile api se
We will create a request which will be in pending
With Web Portal either approve/reject
If approved, background job running which runs every hour, advanced salary 
job against all companies.
And that file is sent to NI
NI sends a feedback against that file, service is made for that 
In our DB status is updated from that service
If success from NI, status is waiting 


FOR RECOVERY:

-Cash load banti hy
-cash load mei pata lag jaye ga iss banday ne advance liya hy
-Then we will send to NI

Recovery statuses: 
pending

Agar cash load file mei advance pata 

=======================Tables========================
select top 5 * from CoreDb.dbo.FNGL_ManualTransactionBatch_HI -- batch table
select top 5 * from CoreDb.dbo.FNGL_ManualTransactionEmployee_HI -- responselog tables
select top 5 * from FNGL_NIManualTransaction_Feedback_HI --feedback status 0 means success and 1 means rejected


===============================SFTP automation==============================
SELECT * FROM EmPStatus_ST
Select * from HRMS_EmpBatch_HI order by 1 desc
select * from HRMS_EmpTracking_HI order by 1 desc
select * from HRMS_EmployeeMst_ST where EmpStatusId=2

D:/Temp Storage> 00 SFTP_KP> CCS_SFD>UAT>ToBeScreened>Individual

Individual means company

20.203.21.188 server

localhost:8083/hangfire

01> Morning job
02> Evening job

========================For adding salaries against employees=============

PAFMaster
PAF Detail in WPS processing DB


==========================For Recovery of Advanced Salary===========

When Salary is processed from desktop portal (cash load), the entries in 
the dbo.status, dbo.AdvanceSalary ,dbo.AdvanceSalaryDetail tables should 
be updated accordingly

The status id should be 48(pending). Also check the debit and credit amounts against that entry.

=====================Recovery Detail==================

ONLY WORKS WHEN status: disburse

RecoveryStatusId: Pending, partially receive, null

ENTRY MUST BE PRESENT IN THESE TABLES BELOW:

-Cashload Master and Cashload Detail TABLES

Select top 1 CashloadMasterId from CoreDb.dbo.PCMS_Cashload_Master
  where
  Status =@StatusId and Companyid= @Companyid and Productid =@Productid )
  Select * from CoreDb.dbo.PCMS_Cashload_Detail
  where CashloadMasterId = 15 and Amount != 0   

-- above will appear in cash load file


If penalty =1 in SELECT * FROM [CoreDb].[dbo].[SystemSettings] table,
SELECT * FROM [CoreDb].[dbo].[AdvanceSalaryDetail] will have 3 entries,
1 seperate entry for charges

Also check the due date along with penalty =1, if due date has passed only
then charges entry will come

For partially recovery, 1 debit and 1 credit entry both of the same amount

If fully recovered, 1 debit entry and 1 credit entry with full payment


===================Advanced salary FULL Detail=========================
select *  from AdvanceSalary
select *  from AdvanceSalaryDetail
select * from AdvanceSalaryStatustracking
select * from AdvanceSalaryCharges


when salary first comes, it goes to pending on Web portal
Accept and send to bank using web portal

Bank ID and Password on WEBPORTAL(send to bank wali requests yahan aein gi) :
User: sadaf	
Password: Sadaf@2021

If bank approves, advanced salary table status changes
Recovery status is pending and advanced status ID is 40

Due date mei last salary date+ 1 month and 10 Days add kero


Loan Pay company ID we will make when loans are given

JobStatus =1 if job hasnt run

JobName = ProcessSentMTPtoNI on hangfire server

NI wants seperate file for each company 

filename mei productcode + MTP + datetime

IServiceManager.ProcessAdvanceSalaryMtp job purpose(file bana deti hy
run with other job): 

D:\00 - SFTP KP\NI_PCMS\PROD\Outbound\2022\Nov\111122 filepath for job	

isme records girein ge when job runs:	
select * from FNGL_ManualTransactionBatch_HI order by 1 desc
select * from FNGL_ManualTransactionEmployee_HI where BatchNo=28

CHECK ALL STATUSES RIGOUROUSLY



FOR processsendMTPfiletoNIJOB(iska koi status nhi):

aaj ki date mei jakay jitni files hein unko NI bhej dega

1>OUTBOUND FILES SENT TO SFTP at NI
2>OUTBOUND FILES WHICH ARE SUCCESSFULLY SENT TO SFTP come to inbound

IMPORTANT NOTE: Folder of today must be created manually in 
WINSCP for outbound/inbound to work
 

After this(this job is not yet made):

NI sends feedback file
NI returns 2 things to us, TransactionRefNo and approve/Reject status

If success, success response in both debit/credit
AdvanceSalaryDetail(this table will only have 
success/fail) will update and will be success 
and go to AdvanceSalary Table.

Advance Salary will be disbursed status if both debit/credit transactions
are successful

FOR SFTP ACCESS: Download: WinSCP
SFTP SERVER IP : 20.74.153.18
SFTP USERNAME : waqas
SFTP PASSWORD : Waqas@123456
PortNo:22


Advanced Eligibility API
Eligible = "01";
NotEligible = "02";
EligibleAndPending = "03";
EligibleAndDue = "04";


=================Feedback Service=================================

NI se file mil jaati hy feedback ki, 
-Iske behalf pe disbursed, patiallly failed and failed


Feedback service k liye file banani hogi

datetime || filename || walletID || transaction reference No || Error code || error desc || status (0 is for success)

After service is run two tables will have entry:

1)FNGL_ManualTransactionEmployee_HI
2)FNGL_NIManualTransaction_Feedback_HI 

AND ALSO IN TRANSACTION TABLE

Select* from transactions
Select * from FNGL_TRANSACTION TYPES

Aik debit transaction banay gi in above tables with amount 

SifID ka record bhi banay gaS

SELECT * from SIFMaster
Select * from cifCompanyLinkings
Select* from cifEmployeeLinking
  (category code 00 = company, 01 = employee)  ===> check sifto(employee) and siffrom (loan pay company ID) 


For transaction statuses, go to status table and check

Jo transactions successful mark hogaye, unme company balance mei add subtract hogi amount(company balance mei)
