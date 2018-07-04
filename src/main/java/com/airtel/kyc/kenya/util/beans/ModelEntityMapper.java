package com.airtel.kyc.kenya.util.beans;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.airtel.kyc.kenya.entity.Role;
import com.airtel.kyc.kenya.entity.Subscriber;
import com.airtel.kyc.kenya.entity.User;
import com.airtel.kyc.kenya.model.RoleModel;
import com.airtel.kyc.kenya.model.SubscriberModel;
import com.airtel.kyc.kenya.model.UserModel;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class ModelEntityMapper {

	private MapperFactory mapperFactory;
	
	public User userModeltoEntity(UserModel userModel){
		mapperFactory = new DefaultMapperFactory.Builder().build();
		if(userModel.getId() <= 0){
			mapperFactory.classMap(UserModel.class, User.class).exclude("id")
			.byDefault()
//			.customize(new CustomMapper<UserModel,User>(){
//				@Override
//				public void mapAtoB(UserModel src, User dest, MappingContext context) {
//					super.mapAtoB(src, dest, context);
//					dest.setCreatedOn(new Timestamp(src.getCreatedOn()));
//					dest.setUpdatedOn(new Timestamp(src.getUpdatedOn()));
//				}
//			})
			.register();
		}else{
			mapperFactory.classMap(UserModel.class, User.class).byDefault()
			.customize(new CustomMapper<UserModel,User>(){
				@Override
				public void mapAtoB(UserModel src, User dest, MappingContext context) {
					super.mapAtoB(src, dest, context);
					dest.setUpdatedOn(new Timestamp(src.getUpdatedOn()));
				}
			})
			.register();
		}
		return mapperFactory.getMapperFacade().map(userModel, User.class);
	}
	
	public UserModel userEntityToUserModel(User user){
		mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(User.class, UserModel.class)
				.byDefault()
				.customize(new CustomMapper<User,UserModel>() {
					@Override
					public void mapAtoB(User a, UserModel b, MappingContext context) {
						super.mapAtoB(a, b, context);
						b.setCreatedOn(a.getCreatedOn().getTime());
						b.setUpdatedOn(a.getUpdatedOn().getTime());
						b.getRole().setSubroles(a.getRole().getSubroles().stream().map(role -> role.getName()).collect(Collectors.toList()));
					}	
				})
				.register();
		return mapperFactory.getMapperFacade().map(user,UserModel.class);
	}
	
	public List<RoleModel> roleEntityToModel(List<Role> role){
		mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(Role.class, RoleModel.class)
		.byDefault()
		.customize(new CustomMapper<Role,RoleModel>() {
			@Override
			public void mapAtoB(Role a, RoleModel b, MappingContext context) {
				super.mapAtoB(a, b, context);
				b.setSubroles(a.getSubroles().stream().map(role -> role.getName()).collect(Collectors.toList()));
			}	
		})
		.register();
		return mapperFactory.getMapperFacade().mapAsList(role,RoleModel.class);
	}

	public Subscriber subscriberModelToEntity(SubscriberModel model){
		mapperFactory = new DefaultMapperFactory.Builder().build();
		if(model.getId() <= 0){
			mapperFactory.classMap(UserModel.class, User.class).exclude("id")
			.byDefault().register();
		}
		mapperFactory.classMap(SubscriberModel.class, Subscriber.class);
		return mapperFactory.getMapperFacade().map(model, Subscriber.class);
	}
}