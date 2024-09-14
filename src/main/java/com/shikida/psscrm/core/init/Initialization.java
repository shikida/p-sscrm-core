package com.shikida.psscrm.core.init;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shikida.psscrm.core.model.Group;
import com.shikida.psscrm.core.model.Model;
import com.shikida.psscrm.core.model.Practice;
import com.shikida.psscrm.core.model.Task;

public class Initialization {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("data");
		File file = new File(dir,"p-sscrm-1_0.json");
		
		Model model = populate_1_0();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		FileWriter fw = new FileWriter(file);
		gson.toJson(model, fw);
		fw.flush();
		fw.close();
	}
	
	public static Model populate_1_0() {

		Task g11 = new Task(
				"G.1.1",
				"Organizational security requirements",
				"Organizational security requirements, such as those imposed by standards and regulations, are included in the SDLC.",
				"Identify, document, communicate, and maintain security requirements and policies for the organization's software development infrastructure and secure SDLC. Maintain the requirements and policies over time. Incorporate constraints imposed by standards and regulations and customer-driven security requirements.");
		
		g11.addQuestion("Do you have a defined secure SDLC that the engineers are aware of?");
		g11.addQuestion("How do you define security requirements and policies for the organization, its development infrastructure, contributions, and processes?");  
		g11.addQuestion("How are these requirements and contributions maintained over time?");  
		g11.addQuestion("How are constraints imposed by regulatory and compliance drivers included in these requirements, policies, and the SDLC?");

		g11.addReference("EO","4e(ix)");
		g11.addReference("SSDF","PO.1.1");
		g11.addReference("BSIMM","CP1.1", "CP1.2", "CP1.3", "SR1.1", "SR2.2", "SR3.3");
		g11.addReference("800-161","SA-15");
		g11.addReference("CNCF SSC","C: Establish and adhere to contribution policies");
		g11.addReference("Self-attestation","2");
		
		Practice g1 = new Practice(
				"G.1",
				"Perform compliance",
				"Compliance is following established guidelines or specifications, possibly demonstrated through an audit.",
				g11);

		Group g = new Group(
				"G",
				"Governance",
				"Tasks that focus on the organization, measurement of a secure software supply chain, decision-making policies, "
				+ "accountability to third-party obligations, and compliance with legal and regulatory requirements.",
				g1);

		Model m = new Model("1.0",g);
		m.getMetadata().put("800-161", "NIST Cybersecurity Supply Chain Risk Management Practices for Systems and Organizations (800-161r1) - only the subset of tasks specifically identified in this document as mapping back to the Executive Order");
		m.getMetadata().put("BSIMM", "Building Security In Maturity Model Version 13");
		m.getMetadata().put("CNCF SSC", "Cloud Native Computing Foundation – Software Supply Chain Best Practices");
		m.getMetadata().put("EO", "Executive Order 14028 (EO)");
		m.getMetadata().put("OSSF Scorecard", "OpenSSF Scorecard metrics");
		m.getMetadata().put("OWASP SCVS", "Open Web Application Security Project Software Component Verification Standard Version 1.0");
		m.getMetadata().put("S2C2F", "OpenSSF Secure Supply Chain Consumption Framework");
		m.getMetadata().put("SLSA", "Supply-chain Levels for Software Artifacts v1.0");
		m.getMetadata().put("SSDF", "NIST Secure Software Development Framework version 1.1 (800-218)");
		m.getMetadata().put("Self-attestation", "DHS/CISA Secure Software Self-Attestation Common Form");
		
		return m;
	}

}
