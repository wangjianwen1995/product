CREATE TABLE [dbo].[sd_info_STEMI]([id] [int] IDENTITY(1,1) NOT NULL,[submit_id] [varchar](255) NULL,[submit_time] [varchar](255) NULL,[check_id] [varchar](255) NULL,[check_time] [varchar](255) NULL,[check_result] [varchar](255) NULL, [status] [int] NULL, [CM_0_1_1_1] [varchar](255) NULL, [CM_0_1_1_2] [varchar](255) NULL, [CM_0_1_1_3] [varchar](255) NULL, [CM_0_1_1_4] [varchar](255) NULL, [CM_0_1_1_5] [varchar](255) NULL, [caseId] [varchar](255) NULL, [IDCard] [varchar](255) NULL, [CM_0_1_3_1] [varchar](255) NULL, [CM_0_1_3_2] [varchar](255) NULL, [CM_0_1_4_1] [varchar](255) NULL, [CM_0_1_4_2] [varchar](255) NULL, [CM_0_1_5] [varchar](255) NULL, [CM_0_2_1_1] [varchar](255) NULL, [CM_0_2_1_2] [varchar](255) NULL, [CM_0_2_1_3] [varchar](255) NULL, [CM_0_2_1_5] [varchar](255) NULL, [CM_0_2_1_3_1] [varchar](255) NULL, [CM_0_2_1_4] [varchar](255) NULL, [CM_0_2_2_1] [varchar](255) NULL, [CM_0_2_2_2] [varchar](255) NULL, [CM_0_2_3_2] [varchar](255) NULL, [CM_0_2_4_1] [varchar](255) NULL, [age] [varchar](255) NULL, [CM_0_2_4_2] [varchar](255) NULL, [CM_0_2_5_1] [varchar](255) NULL, [CM_0_2_5_2] [varchar](255) NULL, [CM_0_3_1] [varchar](255) NULL, [CM_0_3_2] [varchar](255) NULL, [CM_0_3_3] [varchar](255) NULL, [STEMI_0_4_6] [varchar](255) NULL, [STEMI_0_4_1] [varchar](255) NULL, [STEMI_0_4_2] [varchar](255) NULL, [STEMI_0_4_3] [varchar](255) NULL, [STEMI_0_4_4] [varchar](255) NULL, [STEMI_0_4_5] [varchar](255) NULL, [STEMI_0_4_7] [varchar](255) NULL, [STEMI_1_1_4] [varchar](255) NULL, [STEMI_1_1_5] [varchar](255) NULL, [STEMI_1_1_6] [varchar](255) NULL, [STEMI_1_1_7] [varchar](255) NULL, [STEMI_1_1_1] [varchar](255) NULL, [STEMI_1_1_2_1] [varchar](255) NULL, [STEMI_1_1_3] [varchar](255) NULL, [STEMI_1_1_3_1] [varchar](255) NULL, [STEMI_1_2_1] [varchar](255) NULL, [STEMI_1_2_2] [varchar](255) NULL, [STEMI_1_2_2_1] [varchar](255) NULL, [STEMI_1_2_3] [varchar](255) NULL, [STEMI_1_2_3_1] [varchar](255) NULL, [STEMI_1_2_4_1] [varchar](255) NULL, [STEMI_1_3_1_1] [varchar](255) NULL, [STEMI_1_3_1_2_1] [varchar](255) NULL, [STEMI_1_3_2] [varchar](255) NULL, [STEMI_1_4_1_1] [varchar](255) NULL, [STEMI_1_3_3_1] [varchar](255) NULL, [STEMI_1_4_1_2] [varchar](255) NULL, [STEMI_1_4_2_1] [varchar](255) NULL, [STEMI_1_3_3_2] [varchar](255) NULL, [STEMI_1_4_2_2] [varchar](255) NULL, [STEMI_1_4_3_1] [varchar](255) NULL, [STEMI_1_3_3_3] [varchar](255) NULL, [STEMI_1_4_3_2] [varchar](255) NULL, [STEMI_1_4_4_1] [varchar](255) NULL, [STEMI_1_3_3_4] [varchar](255) NULL, [STEMI_1_4_4_2] [varchar](255) NULL, [STEMI_1_4_5_1] [varchar](255) NULL, [STEMI_1_3_3_5] [varchar](255) NULL, [STEMI_1_4_5_2] [varchar](255) NULL, [STEMI_1_4_6_1] [varchar](255) NULL, [STEMI_1_3_3_6] [varchar](255) NULL, [STEMI_1_4_6_2] [varchar](255) NULL, [STEMI_2_1_1] [varchar](255) NULL, [STEMI_2_1_2_1] [varchar](255) NULL, [STEMI_2_1_3] [varchar](255) NULL, [STEMI_2_2_1] [varchar](255) NULL, [STEMI_2_2_2_1] [varchar](255) NULL, [STEMI_2_2_3_1] [varchar](255) NULL, [STEMI_2_2_3_3_1] [varchar](255) NULL, [STEMI_2_2_3_4] [varchar](255) NULL, [STEMI_2_2_3_5] [varchar](255) NULL, [STEMI_2_3_1_1] [varchar](255) NULL, [STEMI_2_3_1_2_1] [varchar](255) NULL, [STEMI_2_3_1_3_1] [varchar](255) NULL, [STEMI_2_3_1_4] [varchar](255) NULL, [STEMI_2_3_3_1] [varchar](255) NULL, [STEMI_2_3_3_2_1] [varchar](255) NULL, [STEMI_2_3_3_3_1] [varchar](255) NULL, [STEMI_2_3_3_4] [varchar](255) NULL, [STEMI_3_0_1_dump] [varchar](255) NULL, [STEMI_3_0_1] [varchar](255) NULL, [STEMI_3_0_2] [varchar](255) NULL, [STEMI_3_1_1] [varchar](255) NULL, [STEMI_3_1_2_1] [varchar](255) NULL, [STEMI_3_1_2_2] [varchar](255) NULL, [STEMI_3_1_2_3] [varchar](255) NULL, [STEMI_3_1_3] [varchar](255) NULL, [STEMI_3_1_4] [varchar](255) NULL, [STEMI_3_1_4_1] [varchar](255) NULL, [STEMI_3_1_5_1] [varchar](255) NULL, [STEMI_3_1_6_1] [varchar](255) NULL, [STEMI_3_1_7_1] [varchar](255) NULL, [STEMI_3_1_8] [varchar](255) NULL, [STEMI_3_1_9] [varchar](255) NULL, [STEMI_3_1_10] [varchar](255) NULL, [STEMI_3_2_1] [varchar](255) NULL, [STEMI_3_2_2_1_3] [varchar](255) NULL, [STEMI_3_2_2_1_1] [varchar](255) NULL, [STEMI_3_2_2_1_2] [varchar](255) NULL, [STEMI_3_2_2] [varchar](255) NULL, [STEMI_3_2_2_1] [varchar](255) NULL, [STEMI_3_2_2_2_1] [varchar](255) NULL, [STEMI_3_2_2_3_1] [varchar](255) NULL, [STEMI_3_2_2_4_1] [varchar](255) NULL, [STEMI_3_2_2_5] [varchar](255) NULL, [STEMI_3_2_3_1] [varchar](255) NULL, [STEMI_3_2_3_2_1] [varchar](255) NULL, [STEMI_3_2_3_2_5] [varchar](255) NULL, [STEMI_3_2_3_2_2] [varchar](255) NULL, [STEMI_3_2_3_2_6] [varchar](255) NULL, [STEMI_3_2_3_2_3] [varchar](255) NULL, [STEMI_3_2_3_2_7] [varchar](255) NULL, [STEMI_3_2_3_2_4] [varchar](255) NULL, [STEMI_3_2_3_2_8] [varchar](255) NULL, [STEMI_3_2_3_3] [varchar](255) NULL, [STEMI_3_2_3_3_1] [varchar](255) NULL, [STEMI_3_2_3_3_2] [varchar](255) NULL, [STEMI_3_2_3_3_2_1] [varchar](255) NULL, [STEMI_3_2_3_3_3] [varchar](255) NULL, [STEMI_3_2_3_3_4] [varchar](255) NULL, [STEMI_3_2_3_3_4_1] [varchar](255) NULL, [STEMI_3_2_3_3_5] [varchar](255) NULL, [STEMI_3_2_3_3_6] [varchar](255) NULL, [STEMI_3_2_3_3_6_1] [varchar](255) NULL, [STEMI_3_2_3_3_7] [varchar](255) NULL, [STEMI_3_2_3_3_8] [varchar](255) NULL, [STEMI_3_2_3_3_8_1] [varchar](255) NULL, [STEMI_3_2_3_9_1] [varchar](255) NULL, [STEMI_3_2_3_3_10] [varchar](255) NULL, [STEMI_3_2_3_3_10_1] [varchar](255) NULL, [STEMI_3_2_3_3_11] [varchar](255) NULL, [STEMI_3_2_3_3_12] [varchar](255) NULL, [STEMI_3_2_3_3_12_1] [varchar](255) NULL, [STEMI_3_2_3_3_13] [varchar](255) NULL, [STEMI_3_2_3_3_14] [varchar](255) NULL, [STEMI_3_2_3_3_14_1] [varchar](255) NULL, [STEMI_3_2_3_15_1] [varchar](255) NULL, [STEMI_3_2_3_3_16] [varchar](255) NULL, [STEMI_3_2_3_3_16_1] [varchar](255) NULL, [STEMI_3_2_4_1] [varchar](255) NULL, [STEMI_3_2_4_2] [varchar](255) NULL, [STEMI_3_2_4_3] [varchar](255) NULL, [STEMI_111] [varchar](255) NULL, [STEMI_3_2_4_4] [varchar](255) NULL, [STEMI_3_2_5_1] [varchar](255) NULL, [STEMI_3_2_5_1_1] [varchar](255) NULL, [STEMI_3_2_5_2] [varchar](255) NULL, [STEMI_3_2_5_2_1] [varchar](255) NULL, [STEMI_3_2_6_1] [varchar](255) NULL, [STEMI_3_2_6_2_1_1] [varchar](255) NULL, [STEMI_3_2_6_2_2] [varchar](255) NULL, [STEMI_3_2_7_1] [varchar](255) NULL, [STEMI_3_2_7_2] [varchar](255) NULL, [STEMI_3_2_7_3] [varchar](255) NULL, [STEMI_3_3_0] [varchar](255) NULL, [STEMI_3_3_1_1] [varchar](255) NULL, [STEMI_3_3_1_1_1] [varchar](255) NULL, [STEMI_3_3_1_2] [varchar](255) NULL, [STEMI_3_3_1_2_1] [varchar](255) NULL, [STEMI_3_3_2] [varchar](255) NULL, [STEMI_3_3_3_1] [varchar](255) NULL, [STEMI_3_3_4_1] [varchar](255) NULL, [STEMI_3_4] [varchar](255) NULL, [STEMI_3_4_1_1] [varchar](255) NULL, [STEMI_3_4_2_1] [varchar](255) NULL, [STEMI_3_4_3_1] [varchar](255) NULL, [STEMI_3_4_4] [varchar](255) NULL, [STEMI_4_1_1] [varchar](255) NULL, [STEMI_4_1_2_1] [varchar](255) NULL, [STEMI_4_1_2_1_1] [varchar](255) NULL, [STEMI_4_1_2_2] [varchar](255) NULL, [STEMI_4_1_2_2_1] [varchar](255) NULL, [STEMI_4_2] [varchar](255) NULL, [STEMI_4_3_1] [varchar](255) NULL, [STEMI_5_1_1] [varchar](255) NULL, [STEMI_5_1_2] [varchar](255) NULL, [STEMI_5_1_2_1] [varchar](255) NULL, [STEMI_5_2_1] [varchar](255) NULL, [STEMI_5_2_2] [varchar](255) NULL, [STEMI_5_3_1] [varchar](255) NULL, [STEMI_5_3_2] [varchar](255) NULL, [STEMI_5_3_3] [varchar](255) NULL, [STEMI_5_3_4_A] [varchar](255) NULL, [STEMI_5_3_4_A_1] [varchar](255) NULL, [STEMI_5_3_4_B] [varchar](255) NULL, [STEMI_5_3_4_B_1] [varchar](255) NULL, [STEMI_5_4_1] [varchar](255) NULL, [STEMI_5_4_2] [varchar](255) NULL, [STEMI_5_4_3] [varchar](255) NULL, [STEMI_5_4_4] [varchar](255) NULL, [STEMI_5_4_4_1] [varchar](255) NULL, [STEMI_6_1] [varchar](255) NULL, [STEMI_6_1_2] [varchar](255) NULL, [STEMI_6_1_2_1] [varchar](255) NULL, [STEMI_6_2] [varchar](255) NULL, [STEMI_6_2_2] [varchar](255) NULL, [STEMI_6_3] [varchar](255) NULL, [STEMI_6_3_2] [varchar](255) NULL, [STEMI_6_3_2_A] [varchar](255) NULL, [STEMI_6_3_2_A_1] [varchar](255) NULL, [STEMI_6_3_2_B] [varchar](255) NULL, [STEMI_6_3_2_B_1] [varchar](255) NULL, [STEMI_6_4] [varchar](255) NULL, [STEMI_6_4_2] [varchar](255) NULL, [STEMI_6_4_2_1] [varchar](255) NULL, [STEMI_6_5_1] [varchar](255) NULL, [STEMI_6_5_2] [varchar](255) NULL, [STEMI_6_5_2_1] [varchar](255) NULL, [STEMI_6_5_3] [varchar](255) NULL, [STEMI_6_5_4] [varchar](255) NULL, [STEMI_6_5_5] [varchar](255) NULL, [STEMI_6_5_6] [varchar](255) NULL, [STEMI_6_5_6_1] [varchar](255) NULL, [STEMI_7_1] [varchar](255) NULL, [STEMI_7_2] [varchar](255) NULL, [STEMI_7_3_1] [varchar](255) NULL, [STEMI_7_3_2] [varchar](255) NULL, [STEMI_7_4] [varchar](255) NULL, [STEMI_7_5] [varchar](255) NULL, [STEMI_8_5_1_1] [varchar](255) NULL, [STEMI_8_5_1_2] [varchar](255) NULL, [STEMI_8_5_1_3] [varchar](255) NULL, [STEMI_8_5_1_4] [varchar](255) NULL, [STEMI_8_5_2_1] [varchar](255) NULL, [STEMI_8_5_2_2] [varchar](255) NULL, [STEMI_8_5_2_3] [varchar](255) NULL, [STEMI_8_5_2_4] [varchar](255) NULL, [STEMI_8_5_2_5] [varchar](255) NULL, [STEMI_8_1_1] [varchar](255) NULL, [STEMI_8_1_2] [varchar](255) NULL, [STEMI_8_1_3] [varchar](255) NULL, [STEMI_8_5_3_1] [varchar](255) NULL, [STEMI_8_2_3_2] [varchar](255) NULL, [STEMI_8_2_2] [varchar](255) NULL, [STEMI_8_3] [varchar](255) NULL, [STEMI_8_4_1] [varchar](255) NULL, [STEMI_8_4_2] [varchar](255) NULL, [STEMI_8_4_3] [varchar](255) NULL, [STEMI_8_4_4] [varchar](255) NULL, [STEMI_8_4_5] [varchar](255) NULL, [STEMI_9_2_1] [varchar](255) NULL, [STEMI_9_2_1_2] [varchar](255) NULL, [STEMI_9_2_2_A_2] [varchar](255) NULL, [STEMI_9_2_2_A_1_1] [varchar](255) NULL, [STEMI_9_2_2_A_3] [varchar](255) NULL, [CM_4_1] [varchar](255) NULL, [CM_4_2] [varchar](255) NULL, [CM_4_3] [varchar](255) NULL, [CM_4_5] [varchar](255) NULL, [CM_4_4_1] [varchar](255) NULL, [CM_4_6] [varchar](255) NULL, [CM_5_1] [varchar](255) NULL, [CM_5_2_1] [varchar](255) NULL, [CM_5_2_2] [varchar](255) NULL, [CM_5_2_3] [varchar](255) NULL, [CM_5_2_5] [varchar](255) NULL, [CM_5_2_6] [varchar](255) NULL, [CM_5_2_7] [varchar](255) NULL, [CM_5_2_8] [varchar](255) NULL, [CM_5_2_9] [varchar](255) NULL, [CM_5_2_10] [varchar](255) NULL, [CM_5_2_11] [varchar](255) NULL, [CM_6_1] [varchar](255) NULL, [CM_6_2] [varchar](255) NULL, [CM_6_3] [varchar](255) NULL, [CM_6_4] [varchar](255) NULL, [CM_6_5] [varchar](255) NULL, [CM_6_6] [varchar](255) NULL, [CM_6_7] [varchar](255) NULL, [CM_6_8] [varchar](255) NULL, [CM_6_9] [varchar](255) NULL, [CM_6_10] [varchar](255) NULL, [CM_6_11] [varchar](255) NULL, [CM_6_12] [varchar](255) NULL, [CM_6_13] [varchar](255) NULL, [CM_6_14] [varchar](255) NULL, [CM_6_15] [varchar](255) NULL, [CM_6_16] [varchar](255) NULL, [CM_6_17] [varchar](255) NULL, [CM_6_18] [varchar](255) NULL, [CM_6_19] [varchar](255) NULL, [CM_6_20] [varchar](255) NULL, [CM_6_21] [varchar](255) NULL, [CM_6_22] [varchar](255) NULL, [CM_6_23] [varchar](255) NULL, [CM_6_24] [varchar](255) NULL, [CM_6_25] [varchar](255) NULL, [CM_6_26] [varchar](255) NULL, [CM_6_27] [varchar](255) NULL, [CM_6_28] [varchar](255) NULL, [CM_6_29] [varchar](255) NULL, [CM_6_30] [varchar](255) NULL, PRIMARY KEY CLUSTERED ([id] ASC)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]