package controller;

import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SkillDAO;
import model.Skill;

public class Main {
	
	static List<Skill> skillList = new ArrayList<Skill>();
	static Skill skill = new Skill(null, null);
	static SkillDAO skillDAO = new SkillDAO();

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter skill Id");
		long skillId = Long.parseLong(br.readLine());
		System.out.println("Enter skill name");
		String skillName = br.readLine();
		skill.setSkillid(skillId);
		skill.setSkillName(skillName);
		skillDAO.insertSkills(skill);

		skillList=skillDAO.listAllSkills();
				if(skillList != null) {
			System.out.println("id\tname");
			for(Skill skll : skillList) {
				System.out.println(skll.getSkillid()+"\t"+skll.getSkillName());		
			}
		}
	}

}