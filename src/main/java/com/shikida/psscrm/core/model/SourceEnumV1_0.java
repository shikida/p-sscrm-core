package com.shikida.psscrm.core.model;

public enum SourceEnumV1_0 {

	NIST_800_161(
			"800-161",
			"NIST Cybersecurity Supply Chain Risk Management Practices for Systems and Organizations (800-161r1) - only the subset of tasks specifically identified in this document as mapping back to the Executive Order"),
	BSIMM("BSIMM", "Building Security In Maturity Model Version 13"),
	CNCF_SSC("CNCF SSC", "Cloud Native Computing Foundation – Software Supply Chain Best Practices"),
	EO("EO", "Executive Order 14028 (EO)"),
	OSSF_SCORECARD("OSSF Scorecard", "OpenSSF Scorecard metrics"),
	OWASP_SCVS(
			"OWASP SCVS",
			"Open Web Application Security Project Software Component Verification Standard Version 1.0"),
	S2C2F("S2C2F", "OpenSSF Secure Supply Chain Consumption Framework"),
	SLSA("SLSA", "Supply-chain Levels for Software Artifacts v1.0"),
	SSDF("SSDF", "NIST Secure Software Development Framework version 1.1 (800-218)"),
	DHS_CISA_SA("Self-attestation", "DHS/CISA Secure Software Self-Attestation Common Form");

	private String prefix;
	private String description;

	private SourceEnumV1_0(String p, String d) {
		this.prefix = p;
		this.description = d;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getDescription() {
		return description;
	}

}
