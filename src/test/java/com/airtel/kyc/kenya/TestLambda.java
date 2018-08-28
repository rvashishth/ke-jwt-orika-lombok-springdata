package com.airtel.kyc.kenya;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.us.app.entity.Role;
import com.us.app.entity.SubRole;

public class TestLambda {

	@Test
	public void testRoleMapping(){
		Role roles = new Role();
		roles.setRolename("roleA");
		SubRole subRole = new SubRole();
		subRole.setName("subRoleA");
		Set<SubRole> set = new HashSet<>();
		set.add(subRole);
		roles.setSubroles(set);
		List<String> collect = roles.getSubroles().stream().map(role -> role.getName()).collect(Collectors.toList());
		System.out.println(collect);
	}
}
