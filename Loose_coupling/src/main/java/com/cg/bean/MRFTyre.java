package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class MRFTyre implements ITyre{
public String getTyreDetails() {
	return "MRF Tyre";
}
}
