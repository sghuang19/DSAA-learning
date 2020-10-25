package assignment_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class JUnitTest {

	@Before
	public void creatList1() {

	}

	@Test
	public void test1() {

		assertEquals("[0, 3, 4]", KMP.KMPFindLocations("aabaaa", "aa").toString());
		assertEquals("[0, 2]", KMP.KMPFindLocations("ABABABC", "ABA").toString());
		assertEquals("[0, 13]",
				KMP.KMPFindLocations("aasdfkjashkhfaashkjghakjsjdhfkjsqeodiaaaaoidfaoskhassdfasd1231412asdfadsasdgasd",
						"aas").toString());
		assertEquals("[8, 10, 12]", KMP.KMPFindLocations("chenljnbwowowoo", "wo").toString());
		assertEquals("[0]", KMP.KMPFindLocations("touristrealgod", "tourist").toString());

		// empty
		assertEquals("[-1]", KMP.KMPFindLocations("aabaaa", "aaaa").toString());
		assertEquals("[-1]", KMP.KMPFindLocations("ABABABC", "aa").toString());
		// overlap
		assertEquals("[0, 3, 6, 9, 12, 15, 18, 22, 27, 30]",
				KMP.KMPFindLocations("testestestestestestesttestttestest", "test").toString());
		assertEquals("[3, 6, 9, 12, 18, 20]", KMP.KMPFindLocations("hellollollollolloololol", "lol").toString());

		assertEquals(3, KMP.KMPSearchTimes("aabaaa", "aa"));
		assertEquals(0, KMP.KMPSearchTimes("ABABABC", "aa"));
		assertEquals(2, KMP.KMPSearchTimes("ABABABC", "ABA"));
		assertEquals(2, KMP.KMPSearchTimes(
				"aasdfkjashkhfaashkjghakjsjdhfkjsqeodiaaaaoidfaoskhassdfasd1231412asdfadsasdgasd", "aas"));
		assertEquals(3, KMP.KMPSearchTimes("chenljnbwowowoo", "wo"));
		assertEquals(1, KMP.KMPSearchTimes("touristrealgod", "tourist"));
		assertEquals(0, KMP.KMPSearchTimes("aabaaa", "aaaa"));
		// overlap
		assertEquals(10, KMP.KMPSearchTimes("testestestestestestesttestttestest", "test"));
		assertEquals(6, KMP.KMPSearchTimes("hellollollollolloololol", "lol"));

	}

	@Test
	public void test2() {

		// multiply
		assertEquals(
				"731ECA763759FEBAE3828A25942EF330CE3AF20F5CA2A2A41F1A644C94FB68FE1105D8DB8B2D794875E45C40B2AD2026CA1EC922624540E1258F579629",
				HexCompute.multiply("ABABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233",
						"ABABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233"));
		assertEquals(
				"727DEE654833558816C232FA733F995447EA4519F1624B709D1A2C75757CFCCF5E1FB632B35C2D60D555505000022233344454532223322FFFFFEEDDCD",
				HexCompute.multiply("AABBCACCDDEEFFAABBBEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						"ABABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233"));
		assertEquals("E1", HexCompute.multiply("F", "F"));
		assertEquals("20D", HexCompute.multiply("23", "F"));
		assertEquals("-20E110D3B", HexCompute.multiply("23123415", "-F"));
		assertEquals("-AAB72334E69BF1C7B57F52C0DA5", HexCompute.multiply("-AABBC23123415", "FFF91237490751"));

		// large
		assertEquals(
				"ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.multiply(
						"1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984",
						"A123124213401273517234520374080123048109293840918235182324127836498712634876123785761827368716263784617823659871623478612783641782637876137846178BABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233"));
		// revert
		assertEquals(
				"ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.multiply(
						"A123124213401273517234520374080123048109293840918235182324127836498712634876123785761827368716263784617823659871623478612783641782637876137846178BABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233",
						"1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984"));

		// negative
		assertEquals(
				"-ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.multiply(
						"-A123124213401273517234520374080123048109293840918235182324127836498712634876123785761827368716263784617823659871623478612783641782637876137846178BABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233",
						"1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984"));
		assertEquals(
				"-ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.multiply(
						"A123124213401273517234520374080123048109293840918235182324127836498712634876123785761827368716263784617823659871623478612783641782637876137846178BABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233",
						"-1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984"));
		assertEquals(
				"A5B9017706F6C5E93D9BA1C7589B112C0B4F052176CC1EB2629501D96E47933D3D2936E515C95CEFB5B7D4466E2C96DA5F954ED03091FD04B808D8679738797B522EB0EF3D64B10139D00A11F5E4732923E54B6019E5DE483D7D0AFA999E23CB23F563D8CD758BCB0324725A5A51479593029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.multiply(
						"-9989871298321649726791635000A123124213401273517234520374080123048109293840918235182324127836498712634876123785761827368716263784617823659871623478612783641782637876137846178BABABABBBBCDDDEEEFFAAAAFAFFFFDDDCCCBBBABACDDDCCDD00000112233",
						"-1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984"));

		// zeros
		assertEquals("0", HexCompute.multiply("0",
				"-1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984"));
		assertEquals("0", HexCompute.multiply(
				"1145141919910FFFFFFABBBCBBBAABBCBABBA11AA123410009120908019274980172359871908273412364781263478619AABBAABBCCDDEEFF028736497812634781287364871726347871623847618762348716AABBBAABCCDDEEFF3081273981723984",
				"0"));
		assertEquals("0", HexCompute.multiply("0", "-0"));
		assertEquals("0", HexCompute.multiply("-0", "-0"));
		assertEquals("0", HexCompute.multiply("0", "0"));
		assertEquals("0", HexCompute.multiply("-0", "0"));
		assertEquals("0", HexCompute.multiply("F000000000000000000000000000000000000000000000000000000000000",
				"000000000000000000000000000000000000000000000000000000000000"));

	}

	@Test
	public void test3() {
		assertEquals("F000000000000000000000000000000000000000000000000000000000000",
				HexCompute.addStrings("F000000000000000000000000000000000000000000000000000000000000",
						"000000000000000000000000000000000000000000000000000000000000"));
		assertEquals("F000000000000000000000000000000000000000000000000000000000000",
				HexCompute.addStrings("F000000000000000000000000000000000000000000000000000000000000",
						"-000000000000000000000000000000000000000000000000000000000000"));
		assertEquals("-F000000000000000000000000000000000000000000000000000000000000",
				HexCompute.addStrings("-F000000000000000000000000000000000000000000000000000000000000",
						"000000000000000000000000000000000000000000000000000000000000"));
		assertEquals("579", HexCompute.addStrings("123", "456"));
		assertEquals("-333", HexCompute.addStrings("123", "-456"));
		assertEquals("-579", HexCompute.addStrings("-123", "-456"));
		assertEquals("-579", HexCompute.addStrings("-456", "-123"));
		assertEquals("-456", HexCompute.addStrings("-456", "-0"));
		// assertEquals("0", HexCompute.addStrings("-0", "-0"));
		assertEquals("-5", HexCompute.addStrings("-2", "-3"));
		assertEquals("-1", HexCompute.addStrings("2", "-3"));
		assertEquals("0", HexCompute.addStrings("3", "-3"));
		assertEquals("-3", HexCompute.addStrings("0", "-3"));
		assertEquals("-3", HexCompute.addStrings("-0", "-3"));
		assertEquals(
				"15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98",
				HexCompute.addStrings(
						"ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
						"ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C"));
		assertEquals(
				"209C6DF28B185D8281DDF792621EF3EA071A71A969829D5118F2AC584C2F270BBF5F7D4E57A1905D57B736284B5EC64847EE31B104653F56543EF1ED2747B1265A06EE5D4A8D69C2F4D57A66C8BC1DEA60E53B8528572C2D5796E965745CFE00215C4B907CEC89FA57308557C1BE1C58C4E9D2EBF72EDA400551836E3C0A841F4E1AF5EA30CD9D92E7BAD28C65B341728E90507E45635490BF40C70BF5EC9FFC9A0B0F9D1D36A81FFE5D42750EAB3ABD672D55A2B55EEC588B327F0FFF1F0C775D3A52B93E4B3557AF7E4",
				HexCompute.addStrings(
						"15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98",
						"ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C"));
		assertEquals(
				"-ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.addStrings(
						"-15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98",
						"ADECF50D9081F2B809F528620B4FBF8AD08D08DCDD634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C"));
		assertEquals(
				"-FFFFFFFFFFFFFFFFFFFFFF0000000000000000000000000000052130AF26F6F6921E025F8A1DA20545F80370DC2A115A11A11B9BB634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C",
				HexCompute.addStrings(
						"-FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98",
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFADECF50D9081F2B809F528620B4FBF8AD08D08DCDDFFFFFFFFFFFF634705DA63972C40FB7AE951FD46F728B301F1D3D120D6E74ECC2C2A4BB3B0177151CC6BFA5F9B7C290621E024F746E2F2340FC4728CCED9409F8CAF713D70D72640F1D324DCC7C1EFF556074193029A42DFE1D102C7295EA0972EC4DF0F95264F36AAC708124BEAE2C0A6F5E51F8BAEF34864D3E462ECC9115D0DA301AD4C1CBC6DAEA6AED03FCA43554335905345F12380AAA1F162704E3BE3F226471E0E71FA41D83BB7FAFFFB50427C9BE1B9314C3BC728FD4C"));
		assertEquals("0", HexCompute.addStrings(
				"-FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98",
				"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98"));
		assertEquals(
				"-1FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE2B7B3D4364207CAE027D4A1882D3EFE2B42342373758D1C17698E5CB103EDEBA547F51BDCA2CC07C74F44835B9D3B30B0A92ECEC05DC54731AFE97E6DF0A418878093DD1B8BC8D03F11CA333B65027E32BDC4F5C35C9903C74C93731F07BFD5581D064C0A690B7F87440B1CA57A825CBB137C3E54993CDAAB1C20492FAB8B029BD7947E2EBBCD21934F918BB3244574368C06B53072F1B6BA9ABB40FF290D550CD6414D17C48E02AA87C589C138EF8FC8991C7839C7E90760EEDFEBFFED4109F26F86E4C530EF1CA3F530",
				HexCompute.addStrings(
						"-FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98",
						"-FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF15BD9EA1B2103E57013EA50C4169F7F15A11A11B9BAC68E0BB4C72E5881F6F5D2A3FA8DEE516603E3A7A241ADCE9D9858549767602EE2A398D7F4BF36F8520C43C049EE8DC5E4681F88E5199DB2813F195EE27AE1AE4C81E3A649B98F83DFEAAC0E8326053485BFC3A2058E52BD412E5D89BE1F2A4C9E6D558E102497D5C5814DEBCA3F175DE690C9A7C8C5D99222BA1B46035A983978DB5D4D5DA07F9486AA866B20A68BE247015543E2C4E09C77C7E44C8E3C1CE3F483B0776FF5FFF6A084F937C3726298778E51FA98"));

	}
}
