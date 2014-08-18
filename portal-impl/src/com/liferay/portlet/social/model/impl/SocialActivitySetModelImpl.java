/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.social.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.social.model.SocialActivitySet;
import com.liferay.portlet.social.model.SocialActivitySetModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SocialActivitySet service. Represents a row in the &quot;SocialActivitySet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.social.model.SocialActivitySetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SocialActivitySetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivitySetImpl
 * @see com.liferay.portlet.social.model.SocialActivitySet
 * @see com.liferay.portlet.social.model.SocialActivitySetModel
 * @generated
 */
@ProviderType
public class SocialActivitySetModelImpl extends BaseModelImpl<SocialActivitySet>
	implements SocialActivitySetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a social activity set model instance should use the {@link com.liferay.portlet.social.model.SocialActivitySet} interface instead.
	 */
	public static final String TABLE_NAME = "SocialActivitySet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "activitySetId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.BIGINT },
			{ "modifiedDate", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "type_", Types.INTEGER },
			{ "extraData", Types.VARCHAR },
			{ "activityCount", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table SocialActivitySet (activitySetId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate LONG,modifiedDate LONG,classNameId LONG,classPK LONG,type_ INTEGER,extraData STRING null,activityCount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table SocialActivitySet";
	public static final String ORDER_BY_JPQL = " ORDER BY socialActivitySet.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SocialActivitySet.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.social.model.SocialActivitySet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.social.model.SocialActivitySet"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.social.model.SocialActivitySet"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long TYPE_COLUMN_BITMASK = 8L;
	public static long USERID_COLUMN_BITMASK = 16L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.social.model.SocialActivitySet"));

	public SocialActivitySetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _activitySetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActivitySetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _activitySetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SocialActivitySet.class;
	}

	@Override
	public String getModelClassName() {
		return SocialActivitySet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("activitySetId", getActivitySetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("type", getType());
		attributes.put("extraData", getExtraData());
		attributes.put("activityCount", getActivityCount());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long activitySetId = (Long)attributes.get("activitySetId");

		if (activitySetId != null) {
			setActivitySetId(activitySetId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createDate = (Long)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String extraData = (String)attributes.get("extraData");

		if (extraData != null) {
			setExtraData(extraData);
		}

		Integer activityCount = (Integer)attributes.get("activityCount");

		if (activityCount != null) {
			setActivityCount(activityCount);
		}
	}

	@Override
	public long getActivitySetId() {
		return _activitySetId;
	}

	@Override
	public void setActivitySetId(long activitySetId) {
		_activitySetId = activitySetId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public long getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	@Override
	public long getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(long modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	@Override
	public String getExtraData() {
		if (_extraData == null) {
			return StringPool.BLANK;
		}
		else {
			return _extraData;
		}
	}

	@Override
	public void setExtraData(String extraData) {
		_extraData = extraData;
	}

	@Override
	public int getActivityCount() {
		return _activityCount;
	}

	@Override
	public void setActivityCount(int activityCount) {
		_activityCount = activityCount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SocialActivitySet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SocialActivitySet toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SocialActivitySet)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SocialActivitySetImpl socialActivitySetImpl = new SocialActivitySetImpl();

		socialActivitySetImpl.setActivitySetId(getActivitySetId());
		socialActivitySetImpl.setGroupId(getGroupId());
		socialActivitySetImpl.setCompanyId(getCompanyId());
		socialActivitySetImpl.setUserId(getUserId());
		socialActivitySetImpl.setCreateDate(getCreateDate());
		socialActivitySetImpl.setModifiedDate(getModifiedDate());
		socialActivitySetImpl.setClassNameId(getClassNameId());
		socialActivitySetImpl.setClassPK(getClassPK());
		socialActivitySetImpl.setType(getType());
		socialActivitySetImpl.setExtraData(getExtraData());
		socialActivitySetImpl.setActivityCount(getActivityCount());

		socialActivitySetImpl.resetOriginalValues();

		return socialActivitySetImpl;
	}

	@Override
	public int compareTo(SocialActivitySet socialActivitySet) {
		int value = 0;

		if (getModifiedDate() < socialActivitySet.getModifiedDate()) {
			value = -1;
		}
		else if (getModifiedDate() > socialActivitySet.getModifiedDate()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialActivitySet)) {
			return false;
		}

		SocialActivitySet socialActivitySet = (SocialActivitySet)obj;

		long primaryKey = socialActivitySet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SocialActivitySetModelImpl socialActivitySetModelImpl = this;

		socialActivitySetModelImpl._originalGroupId = socialActivitySetModelImpl._groupId;

		socialActivitySetModelImpl._setOriginalGroupId = false;

		socialActivitySetModelImpl._originalUserId = socialActivitySetModelImpl._userId;

		socialActivitySetModelImpl._setOriginalUserId = false;

		socialActivitySetModelImpl._originalClassNameId = socialActivitySetModelImpl._classNameId;

		socialActivitySetModelImpl._setOriginalClassNameId = false;

		socialActivitySetModelImpl._originalClassPK = socialActivitySetModelImpl._classPK;

		socialActivitySetModelImpl._setOriginalClassPK = false;

		socialActivitySetModelImpl._originalType = socialActivitySetModelImpl._type;

		socialActivitySetModelImpl._setOriginalType = false;

		socialActivitySetModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SocialActivitySet> toCacheModel() {
		SocialActivitySetCacheModel socialActivitySetCacheModel = new SocialActivitySetCacheModel();

		socialActivitySetCacheModel.activitySetId = getActivitySetId();

		socialActivitySetCacheModel.groupId = getGroupId();

		socialActivitySetCacheModel.companyId = getCompanyId();

		socialActivitySetCacheModel.userId = getUserId();

		socialActivitySetCacheModel.createDate = getCreateDate();

		socialActivitySetCacheModel.modifiedDate = getModifiedDate();

		socialActivitySetCacheModel.classNameId = getClassNameId();

		socialActivitySetCacheModel.classPK = getClassPK();

		socialActivitySetCacheModel.type = getType();

		socialActivitySetCacheModel.extraData = getExtraData();

		String extraData = socialActivitySetCacheModel.extraData;

		if ((extraData != null) && (extraData.length() == 0)) {
			socialActivitySetCacheModel.extraData = null;
		}

		socialActivitySetCacheModel.activityCount = getActivityCount();

		return socialActivitySetCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{activitySetId=");
		sb.append(getActivitySetId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", extraData=");
		sb.append(getExtraData());
		sb.append(", activityCount=");
		sb.append(getActivityCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.social.model.SocialActivitySet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>activitySetId</column-name><column-value><![CDATA[");
		sb.append(getActivitySetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraData</column-name><column-value><![CDATA[");
		sb.append(getExtraData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityCount</column-name><column-value><![CDATA[");
		sb.append(getActivityCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SocialActivitySet.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SocialActivitySet.class
		};
	private long _activitySetId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _createDate;
	private long _modifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private String _extraData;
	private int _activityCount;
	private long _columnBitmask;
	private SocialActivitySet _escapedModel;
}