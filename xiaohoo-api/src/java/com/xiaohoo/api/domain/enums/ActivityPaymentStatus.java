/**
 * 
 */
package com.xiaohoo.api.domain.enums;

/**
 * 用户参加活动状态
 * @author haojwang
 *
 */
public enum ActivityPaymentStatus {

	UnPaid/* 报名，但还未支付 */, Expired/* 半个小时未支付，报名过期 */, Success/* 支付成功 */;
}
