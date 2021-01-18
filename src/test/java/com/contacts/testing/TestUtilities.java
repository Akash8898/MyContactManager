package com.contacts.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.contacts.contact.Contact;
import com.contacts.utilities.FileUtilities;
import com.contacts.utilities.Utilities;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestUtilities {

	@Mock
	private Contact contact;
	
	@Mock
	private File file;

//	@InjectMocks
//	private FileUtilities util;

	private Utilities utils;

	@Before
	public void setup() {
		FileUtilities fileUtil = new FileUtilities();
		utils = spy(fileUtil);
	}

	@Test
	public void testInvalidMailWrite() throws IOException {

		when(contact.getEmail()).thenReturn("invalidmail");
//		util.write(contact);
		utils.fileWrite(contact);

	}

	@Test
	public void testValidMailWrite() throws IOException {

		when(contact.getEmail()).thenReturn("valid.email@somemail.com");
//		util.write(contact);
		utils.fileWrite(contact);

	}

	@Test
	public void testFormatNumberFalse() {

		assertEquals("Invalid Phone Number", utils.formatNumber(5552125478l, 1));
		assertEquals("Invalid Phone Number", utils.formatNumber(824521256l, 91));
		assertEquals("Invalid Phone Number", utils.formatNumber(55212547l, 63));
		assertEquals("Invalid Phone Number", utils.formatNumber(875423141451l, 404));
		assertEquals("Invalid Phone Number", utils.formatNumber(0l, 1));
	}

	@Test
	public void testFormatNumberTrue() {

		assertEquals("+91 87540 64243", utils.formatNumber(8754064243l, 91));
		assertEquals("+1 202-555-8965", utils.formatNumber(2025558965l, 1));
		assertEquals("+91 89399 04119", utils.formatNumber(8939904119l, 91));
		assertEquals("+63 956 840 6494", utils.formatNumber(9568406494l, 63));
		assertEquals("+1 864-633-9049", utils.formatNumber(8646339049l, 1));
	}

	@Test
	public void testSearchTrue() throws IOException {

		utils.fileSearch("akash");

	}

	@Test
	public void testEmptyView() throws IOException {

//		when(util.file.length()).thenReturn(0l);
//		utils.fileView();
		
		when(file.length()).thenReturn(0l);
		utils.fileView();
		
	}

	@Test
	public void testView() throws IOException {

//		when(util.file.length()).thenReturn(5l);
//		utils.fileView();
		
//		when(file.length()).thenReturn(5l);
		utils.fileView();
	}

	@Test
	public void testSearchFalse() throws IOException {

		utils.fileSearch("9876543722214");

	}

	@Test
	public void testExport() throws IOException {

		utils.fileExport(25);

	}

}
