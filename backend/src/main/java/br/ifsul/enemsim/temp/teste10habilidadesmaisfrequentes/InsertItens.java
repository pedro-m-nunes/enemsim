package br.ifsul.enemsim.temp.teste10habilidadesmaisfrequentes;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.domain.Habilidade;
import br.ifsul.enemsim.domain.Item;
import br.ifsul.enemsim.domain.Prova;
import br.ifsul.enemsim.domain.auxiliar.Resposta;
import br.ifsul.enemsim.repositories.ItemRepository;
import jakarta.annotation.PostConstruct;

@Component
@DependsOn({"insertHabilidades", "insertProvas"})
public class InsertItens {
	
	@Autowired
	private ItemRepository itemRepository; // controller?
	
	@PostConstruct
	public void run() {
		if(itemRepository.count() == 0) {
			Set<Item> itens = new LinkedHashSet<>();
			
			// adicionar itens inválidos?
			
			itens.add(new Item("1B8nxgFiM_p15LadNKj1Brw-1m2TYvD0a", Resposta.A, new Habilidade((byte) 6), new BigDecimal("2.15675"), new BigDecimal("0.94349"), new BigDecimal("0.17590"), new Prova(7), (short) 143));
			itens.add(new Item("1WIcRrcIXKyZo7lZzZApeMoQFmfE2F0WS", Resposta.A, new Habilidade((byte) 7), new BigDecimal("3.46951"), new BigDecimal("4.11405"), new BigDecimal("0.12580"), new Prova(7), (short) 145));
			itens.add(new Item("15Ah9-EPtcPmJ6YwqnZoqdYfVLWZiLLkn", Resposta.E, new Habilidade((byte) 5), new BigDecimal("1.03003"), new BigDecimal("2.09956"), new BigDecimal("0.17070"), new Prova(7), (short) 148));
			itens.add(new Item("1LfxUF60W2UZxGMlFNS1rYkydbW7K4-ZT", Resposta.D, new Habilidade((byte) 10), new BigDecimal("3.41203"), new BigDecimal("3.87930"), new BigDecimal("0.05419"), new Prova(7), (short) 149));
			itens.add(new Item("1pXJJtavxGzdKmGaaJzm3mu9joAq1LtRn", Resposta.C, new Habilidade((byte) 8), new BigDecimal("2.15388"), new BigDecimal("2.04178"), new BigDecimal("0.28781"), new Prova(7), (short) 150));
			itens.add(new Item("1zCqwRn7DOn8t8xqbrMH3PiJDtpKtRqOb", Resposta.A, new Habilidade((byte) 6), new BigDecimal("1.42194"), new BigDecimal("1.80813"), new BigDecimal("0.27450"), new Prova(7), (short) 151));
			itens.add(new Item("1T3mRNF2jgA4QhdM-bu2h7yeuMfyh-t8o", Resposta.D, new Habilidade((byte) 3), new BigDecimal("0.87277"), new BigDecimal("2.82511"), new BigDecimal("0.21108"), new Prova(7), (short) 152));
			itens.add(new Item("1qNuoJpshxBhbb1E2HZURDDfSfyQLduHb", Resposta.E, new Habilidade((byte) 3), new BigDecimal("1.16472"), new BigDecimal("3.02993"), new BigDecimal("0.10360"), new Prova(7), (short) 155));
			itens.add(new Item("1jxCmRpUNYLP4AnMACZQCh90ka6A18Noe", Resposta.C, new Habilidade((byte) 5), new BigDecimal("1.98262"), new BigDecimal("2.01086"), new BigDecimal("0.12481"), new Prova(7), (short) 156));
			itens.add(new Item("1MMUZ4iT2lNkwUQ3SaJKrFWa-s8a-3Qst", Resposta.C, new Habilidade((byte) 4), new BigDecimal("1.74587"), new BigDecimal("2.17499"), new BigDecimal("0.30318"), new Prova(7), (short) 162));
			itens.add(new Item("1bsbsrAuhH5ieykoIu1J0nlr5NZxLV3al", Resposta.E, new Habilidade((byte) 7), new BigDecimal("3.41610"), new BigDecimal("4.31587"), new BigDecimal("0.12228"), new Prova(7), (short) 165));
			itens.add(new Item("1atAWXT-6iCWzOy3eQj5VnJxTqhyHiRB_", Resposta.C, new Habilidade((byte) 1), new BigDecimal("1.76491"), new BigDecimal("1.26471"), new BigDecimal("0.11821"), new Prova(7), (short) 169));
			itens.add(new Item("1C6FyZzVxrj5smDnkaA1xKbKw9i_PPqus", Resposta.A, new Habilidade((byte) 2), new BigDecimal("1.70587"), new BigDecimal("3.19644"), new BigDecimal("0.20825"), new Prova(7), (short) 170));
			itens.add(new Item("1ysyMV5a0FVqbvUm2HDgvA6marYpJTEuv", Resposta.E, new Habilidade((byte) 1), new BigDecimal("1.54884"), new BigDecimal("0.96427"), new BigDecimal("0.24491"), new Prova(7), (short) 177));
			itens.add(new Item("1g7RfZYJ6wHNUo48LAFOQu4tYE2yNqJP4", Resposta.B, new Habilidade((byte) 9), new BigDecimal("1.49174"), new BigDecimal("-0.42299"), new BigDecimal("0.19323"), new Prova(7), (short) 178));
			itens.add(new Item("1RJOSnrKOikOHHpRqotBNC0SK4grnDdkF", Resposta.C, new Habilidade((byte) 10), new BigDecimal("1.06024"), new BigDecimal("-0.23853"), new BigDecimal("0.20527"), new Prova(7), (short) 180)); //acaba 2015
			itens.add(new Item("1-5PwLh6qZ4R_C5yTaFYW0_mcQtI03Mw_", Resposta.C, new Habilidade((byte) 9), new BigDecimal("1.64539"), new BigDecimal("1.89258"), new BigDecimal("0.19287"), new Prova(6), (short) 136));
			itens.add(new Item("1ED5fAPTH_NlQnI1Y-pPoGI_6qt4oJQPt", Resposta.A, new Habilidade((byte) 8), new BigDecimal("1.82869"), new BigDecimal("1.82931"), new BigDecimal("0.18734"), new Prova(6), (short) 138));
			itens.add(new Item("1p_RtDqAcLUmTkQOiSpE7iXn0BsSbQfB2", Resposta.A, new Habilidade((byte) 9), new BigDecimal("1.89960"), new BigDecimal("2.10590"), new BigDecimal("0.10770"), new Prova(6), (short) 139));
			itens.add(new Item("1g5cqEvM5V9mHbg5jCGfkXT_2BTRCF5VJ", Resposta.D, new Habilidade((byte) 7), new BigDecimal("0.86661"), new BigDecimal("3.92011"), new BigDecimal("0.18600"), new Prova(6), (short) 145));
			itens.add(new Item("1Yu8DZrM8uATnZLIswllIYmJOgUqgUYR5", Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.98636"), new BigDecimal("2.03775"), new BigDecimal("0.14588"), new Prova(6), (short) 146));
			itens.add(new Item("1ybQf_V9gcdY_zpiZByYfEWCgbWjcMgIf", Resposta.C, new Habilidade((byte) 10), new BigDecimal("1.63497"), new BigDecimal("3.74711"), new BigDecimal("0.20983"), new Prova(6), (short) 147));
			itens.add(new Item("1TNFGhWlT5U5L0NcdZHbslALbxu5HNbtt", Resposta.D, new Habilidade((byte) 10), new BigDecimal("1.11894"), new BigDecimal("0.27904"), new BigDecimal("0.19659"), new Prova(6), (short) 148));
			itens.add(new Item("1HNcxZSJPwXA3uq9DIut7BKjDLXWVl-2P", Resposta.D, new Habilidade((byte) 8), new BigDecimal("1.60951"), new BigDecimal("3.12558"), new BigDecimal("0.13029"), new Prova(6), (short) 151));
			itens.add(new Item("12G0x5VQPQJsA-872tJ5unzmBcjW7VW8J", Resposta.C, new Habilidade((byte) 7), new BigDecimal("2.10247"), new BigDecimal("2.63616"), new BigDecimal("0.27970"), new Prova(6), (short) 152));
			itens.add(new Item("1x2vTX6kdjRZIwnO3YpvTUcy3eopdFrj7", Resposta.E, new Habilidade((byte) 2), new BigDecimal("2.05535"), new BigDecimal("2.59645"), new BigDecimal("0.17208"), new Prova(6), (short) 153));
			itens.add(new Item("1CeIi5jz94nLAPeHRAJ_T3KeigbBM6Scq", Resposta.A, new Habilidade((byte) 2), new BigDecimal("1.35187"), new BigDecimal("2.42336"), new BigDecimal("0.15877"), new Prova(6), (short) 157));
			itens.add(new Item("19UPB5q_KWVtGTWIAsIDtAZmh7pPLaNlL", Resposta.D, new Habilidade((byte) 1), new BigDecimal("1.50889"), new BigDecimal("1.52149"), new BigDecimal("0.16712"), new Prova(6), (short) 158));
			itens.add(new Item("1kYnnDaZC46gstaKUaos0lAXEk3lq_c69", Resposta.E, new Habilidade((byte) 5), new BigDecimal("2.94115"), new BigDecimal("4.08667"), new BigDecimal("0.13540"), new Prova(6), (short) 162));
			itens.add(new Item("1CwmvETZ0UGZhnbobBFrel7vERyeQ1XoU", Resposta.A, new Habilidade((byte) 4), new BigDecimal("1.75245"), new BigDecimal("1.16274"), new BigDecimal("0.08471"), new Prova(6), (short) 164));
			itens.add(new Item("1ijBBlbSmvLaU-dteND4hEtGQCd7GZ1fT", Resposta.C, new Habilidade((byte) 6), new BigDecimal("1.07664"), new BigDecimal("1.11684"), new BigDecimal("0.13937"), new Prova(6), (short) 165));
			itens.add(new Item("1qFnmANiICL8FECAwq5p2khyVOS_QTMr5", Resposta.A, new Habilidade((byte) 3), new BigDecimal("1.46119"), new BigDecimal("2.45335"), new BigDecimal("0.12054"), new Prova(6), (short) 168));
			itens.add(new Item("1CMXpFBWdI4VWZJBkB_t3WQ2k8cvScjhJ", Resposta.B, new Habilidade((byte) 4), new BigDecimal("1.82503"), new BigDecimal("1.84464"), new BigDecimal("0.15051"), new Prova(6), (short) 169));
			itens.add(new Item("119KGRBqQTT7FtAjA3-5kCiZWhCagpZPK", Resposta.D, new Habilidade((byte) 3), new BigDecimal("1.15634"), new BigDecimal("2.81506"), new BigDecimal("0.10382"), new Prova(6), (short) 170)); //acaba 2016
			itens.add(new Item("1mBdEj76sr5ZxFvG1ZiYgu-T-mQQmroWv", Resposta.D, new Habilidade((byte) 4), new BigDecimal("3.05583"), new BigDecimal("1.34943"), new BigDecimal("0.10809"), new Prova(5), (short) 137));
			itens.add(new Item("1KmxcLv0h9A8IEoA2poISCWD0XkUYD9Bv", Resposta.E, new Habilidade((byte) 5), new BigDecimal("2.66415"), new BigDecimal("1.64983"), new BigDecimal("0.09545"), new Prova(5), (short) 139));
			itens.add(new Item("1OOrXEq5I-bEb6sW7_y_5kMoBonQ6jLuC", Resposta.E, new Habilidade((byte) 2), new BigDecimal("2.43503"), new BigDecimal("1.63320"), new BigDecimal("0.12168"), new Prova(5), (short) 149));
//			itens.add(new Item(null, null, new Habilidade((byte) 4), null, null, null, new Prova(5), (short) 150));
			itens.add(new Item("1VDSqhluwgCPGdSoADeDZp8kULoM2mxLJ", Resposta.E, new Habilidade((byte) 8), new BigDecimal("1.25148"), new BigDecimal("0.88381"), new BigDecimal("0.13308"), new Prova(5), (short) 156));
			itens.add(new Item("1Uq6lClxW-mK8EceX2C7tPUHAnLH3u2uq", Resposta.A, new Habilidade((byte) 9), new BigDecimal("1.47034"), new BigDecimal("3.31311"), new BigDecimal("0.14240"), new Prova(5), (short) 157));
			itens.add(new Item("1ak8Ftt2H-Jy-jHO2J_wzNiCAB2r3AwMV", Resposta.C, new Habilidade((byte) 3), new BigDecimal("2.55414"), new BigDecimal("2.66770"), new BigDecimal("0.22815"), new Prova(5), (short) 159));
			itens.add(new Item("1OUruwkbQSMcmcIoTd2EzJk3MSp-FH1sw", Resposta.C, new Habilidade((byte) 3), new BigDecimal("1.15923"), new BigDecimal("1.57022"), new BigDecimal("0.17437"), new Prova(5), (short) 160));
			itens.add(new Item("13IS1kDRai0M8KaCB1u2FhRq8gEYJ8C-L", Resposta.C, new Habilidade((byte) 2), new BigDecimal("1.78838"), new BigDecimal("2.97454"), new BigDecimal("0.24777"), new Prova(5), (short) 161));
			itens.add(new Item("1nRcBhZyLk6qewYQjYMsJULxkfiEElhzA", Resposta.C, new Habilidade((byte) 10), new BigDecimal("3.06510"), new BigDecimal("1.86549"), new BigDecimal("0.14637"), new Prova(5), (short) 162));
			itens.add(new Item("1Wj0kj0Qr8o97B4IVQoU-tQZOT8LblceL", Resposta.D, new Habilidade((byte) 10), new BigDecimal("2.92985"), new BigDecimal("1.87774"), new BigDecimal("0.13712"), new Prova(5), (short) 163));
			itens.add(new Item("1pU7ZmbK7mBdwK4EnLKjRdhQwL2QSljL4", Resposta.A, new Habilidade((byte) 1), new BigDecimal("1.75065"), new BigDecimal("2.41940"), new BigDecimal("0.14805"), new Prova(5), (short) 164));
			itens.add(new Item("1HM4GOvBO3HOaDLG8Cgh8uJwixv7lJZB5", Resposta.D, new Habilidade((byte) 8), new BigDecimal("3.16831"), new BigDecimal("1.44943"), new BigDecimal("0.19086"), new Prova(5), (short) 167));
			itens.add(new Item("1vaN5dkqIpiTSixp8LD8CVULMDnndzccr", Resposta.D, new Habilidade((byte) 7), new BigDecimal("1.92900"), new BigDecimal("3.00800"), new BigDecimal("0.18500"), new Prova(5), (short) 168));
			itens.add(new Item("1eh9NQyY0heLiEDXIiNgSWvAX_0BdJb1s", Resposta.A, new Habilidade((byte) 6), new BigDecimal("2.10243"), new BigDecimal("1.89084"), new BigDecimal("0.11933"), new Prova(5), (short) 169));
			itens.add(new Item("1E6fQ9i30RilIkrR6mD2eWxoukTJva_5d", Resposta.B, new Habilidade((byte) 7), new BigDecimal("2.60715"), new BigDecimal("3.02371"), new BigDecimal("0.30706"), new Prova(5), (short) 172));
			itens.add(new Item("1lwvlQIYV4jtgh1FphrsbN7NL4ie-Dxgy", Resposta.C, new Habilidade((byte) 9), new BigDecimal("1.88752"), new BigDecimal("2.03259"), new BigDecimal("0.09961"), new Prova(5), (short) 173));
			itens.add(new Item("1c76qNUtKZIeA2eUYH0LUrci6XT3XDHKU", Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.06810"), new BigDecimal("2.89341"), new BigDecimal("0.16386"), new Prova(5), (short) 179)); //acaba 2018
			itens.add(new Item("1LXpSKAIBcbLJUulyyAS1TwNepy5UM1MP", Resposta.E, new Habilidade((byte) 2), new BigDecimal("1.25552"), new BigDecimal("1.93449"), new BigDecimal("0.06675"), new Prova(4), (short) 137));
			itens.add(new Item("1zxQEE2nPgkEDjz4E2TWMxz3Ddiu_1Xzt", Resposta.D, new Habilidade((byte) 8), new BigDecimal("1.51000"), new BigDecimal("3.00300"), new BigDecimal("0.14700"), new Prova(4), (short) 138));
			itens.add(new Item("1GEi_oIlMfnLox-tjeJwzxgwmffBIVmLD", Resposta.E, new Habilidade((byte) 7), new BigDecimal("2.28700"), new BigDecimal("2.21700"), new BigDecimal("0.08500"), new Prova(4), (short) 140));
			itens.add(new Item("1VY06b51DLMywUzHKouiMqrefmhzdPJPf", Resposta.A, new Habilidade((byte) 4), new BigDecimal("1.78432"), new BigDecimal("1.16670"), new BigDecimal("0.04550"), new Prova(4), (short) 143));
			itens.add(new Item("1aV-sE5Ue27v7lqVfL-R4wwsjNfb1i3M-", Resposta.D, new Habilidade((byte) 1), new BigDecimal("1.86876"), new BigDecimal("0.42930"), new BigDecimal("0.12552"), new Prova(4), (short) 144));
			itens.add(new Item("11xJn6zXrUa_MN6A5ihDRNimXM0F-SH7v", Resposta.A, new Habilidade((byte) 1), new BigDecimal("1.12267"), new BigDecimal("0.37213"), new BigDecimal("0.26876"), new Prova(4), (short) 148));
			itens.add(new Item("1OPF5Au-Y0ktfEUiRmwyz2zzYgw7BAQOq", Resposta.A, new Habilidade((byte) 9), new BigDecimal("2.72919"), new BigDecimal("1.92868"), new BigDecimal("0.23186"), new Prova(4), (short) 150));
			itens.add(new Item("1fAC_ICI08Li1D1W9rWWhe12JCjwiHuxP", Resposta.E, new Habilidade((byte) 3), new BigDecimal("3.17618"), new BigDecimal("2.35696"), new BigDecimal("0.27294"), new Prova(4), (short) 157));
			itens.add(new Item("1HJlABdGa4MXraFnQThWek5wulmGIgs1h", Resposta.C, new Habilidade((byte) 7), new BigDecimal("1.72060"), new BigDecimal("2.05336"), new BigDecimal("0.18597"), new Prova(4), (short) 158));
			itens.add(new Item("16YXmKvxBvDeEAchyiicwN3uvVPdYXECS", Resposta.E, new Habilidade((byte) 2), new BigDecimal("3.93635"), new BigDecimal("3.78057"), new BigDecimal("0.19828"), new Prova(4), (short) 159));
			itens.add(new Item("10muQQcD0u40HuMzMUZQulqVis_3_c98n", Resposta.C, new Habilidade((byte) 3), new BigDecimal("2.45518"), new BigDecimal("2.61221"), new BigDecimal("0.15911"), new Prova(4), (short) 160));
			itens.add(new Item("1weoBObgpfGZifNjDGGcK2hBYOiW_X_Ic", Resposta.A, new Habilidade((byte) 5), new BigDecimal("3.76775"), new BigDecimal("2.42062"), new BigDecimal("0.20831"), new Prova(4), (short) 161));
			itens.add(new Item("1r2UHTHfKPdDh42vM1PxM9GKaru932a1O", Resposta.C, new Habilidade((byte) 10), new BigDecimal("2.17954"), new BigDecimal("1.95289"), new BigDecimal("0.13818"), new Prova(4), (short) 165));
			itens.add(new Item("12u73-X-UDAUfFMH78Qd_79uAAHnQAci5", Resposta.C, new Habilidade((byte) 4), new BigDecimal("3.41848"), new BigDecimal("1.95818"), new BigDecimal("0.16938"), new Prova(4), (short) 168));
			itens.add(new Item("1qpzssqchflQjh_nqsNEyFV1Velz1LzcQ", Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.52296"), new BigDecimal("2.72201"), new BigDecimal("0.36496"), new Prova(4), (short) 171));
			itens.add(new Item("14q3Yy_dGZb8orZuT0B6Lv0XCKDgqGPWF", Resposta.B, new Habilidade((byte) 8), new BigDecimal("4.12689"), new BigDecimal("2.88940"), new BigDecimal("0.12635"), new Prova(4), (short) 175));
			itens.add(new Item("1EYkPUCcpAbwZWPNvjSMELXIYpJsUhpEF", Resposta.E, new Habilidade((byte) 10), new BigDecimal("2.59370"), new BigDecimal("1.91179"), new BigDecimal("0.07742"), new Prova(4), (short) 176));
			itens.add(new Item("1M1Mc30QDokGWC2NN6eyrESM06UkHhBuR", Resposta.C, new Habilidade((byte) 9), new BigDecimal("5.31206"), new BigDecimal("3.34343"), new BigDecimal("0.16052"), new Prova(4), (short) 177));
			itens.add(new Item("1hJgTjqyT_ZC1Tv8thLPghxFrVw1gXZnx", Resposta.D, new Habilidade((byte) 6), new BigDecimal("2.24304"), new BigDecimal("2.30004"), new BigDecimal("0.20665"), new Prova(4), (short) 178));
			itens.add(new Item("1zHWzV1UbWPDQp1qSe1odZHckJ8a7K9mi", Resposta.D, new Habilidade((byte) 7), new BigDecimal("2.58330"), new BigDecimal("1.63345"), new BigDecimal("0.16356"), new Prova(4), (short) 180)); //acaba 2019
			itens.add(new Item("1M1sTCS5Wg8fUujlDqo08AnSbYQB1i8_2", Resposta.E, new Habilidade((byte) 5), new BigDecimal("1.20090"), new BigDecimal("0.84968"), new BigDecimal("0.16359"), new Prova(3), (short) 137));
			itens.add(new Item("1p1-3-FJOFzn-uFYCKym86y6ENL-EJwKC", Resposta.C, new Habilidade((byte) 7), new BigDecimal("3.29625"), new BigDecimal("2.86173"), new BigDecimal("0.25529"), new Prova(3), (short) 139));
//			itens.add(new Item(null, null, new Habilidade((byte) 10), null, null, null, new Prova(3), (short) 141));
			itens.add(new Item("1LTSd5DIA6Tlu-JMb2NPA2U-Kab22OKiE", Resposta.C, new Habilidade((byte) 3), new BigDecimal("1.78193"), new BigDecimal("3.29884"), new BigDecimal("0.18914"), new Prova(3), (short) 142));
			itens.add(new Item("1mkjV9bGTV4mM5GABg9kD-GEoa5AUIxun", Resposta.C, new Habilidade((byte) 4), new BigDecimal("0.96583"), new BigDecimal("2.50648"), new BigDecimal("0.20490"), new Prova(3), (short) 143));
			itens.add(new Item("1WgzfKUs1fQvh2pxBsaIrnDExBoHc_fbM", Resposta.C, new Habilidade((byte) 1), new BigDecimal("2.18282"), new BigDecimal("2.31084"), new BigDecimal("0.14885"), new Prova(3), (short) 147));
			itens.add(new Item("19lpbGfqymH5GZyifixkPjqrjtfA8N6zS", Resposta.A, new Habilidade((byte) 1), new BigDecimal("1.58670"), new BigDecimal("-0.08552"), new BigDecimal("0.20086"), new Prova(3), (short) 149));
			itens.add(new Item("1UqxbVpeXiC40GXnY5yj5gACaEX_sbFcj", Resposta.C, new Habilidade((byte) 9), new BigDecimal("2.75624"), new BigDecimal("0.62447"), new BigDecimal("0.09203"), new Prova(3), (short) 151));
			itens.add(new Item("1PRjA6PcgNI3kF9JxEOubruMxkph7-O0A", Resposta.A, new Habilidade((byte) 3), new BigDecimal("1.73821"), new BigDecimal("2.68030"), new BigDecimal("0.13986"), new Prova(3), (short) 153));
			itens.add(new Item("1C_49qda43rldoN4wH-iTpvPE_qaDIChY", Resposta.C, new Habilidade((byte) 8), new BigDecimal("2.96092"), new BigDecimal("0.89580"), new BigDecimal("0.18532"), new Prova(3), (short) 155));
			itens.add(new Item("1uxBUsqYCs4WSmjQleiVyewaQBlHxniop", Resposta.C, new Habilidade((byte) 5), new BigDecimal("2.99017"), new BigDecimal("1.89021"), new BigDecimal("0.15884"), new Prova(3), (short) 158));
			itens.add(new Item("1SzQOqPIGusW9sKvwITi-04w1QHMBW1y7", Resposta.E, new Habilidade((byte) 10), new BigDecimal("2.09221"), new BigDecimal("0.99371"), new BigDecimal("0.13290"), new Prova(3), (short) 163));
			itens.add(new Item("1_VfN3deH5LvkJ08P1fqUt6cycPFvFybw", Resposta.B, new Habilidade((byte) 2), new BigDecimal("2.59667"), new BigDecimal("1.34028"), new BigDecimal("0.15449"), new Prova(3), (short) 166));
			itens.add(new Item("18pm92EBV8UuZVXEp-Rcv1RAVSvDnWdoI", Resposta.D, new Habilidade((byte) 9), new BigDecimal("2.04724"), new BigDecimal("1.08171"), new BigDecimal("0.17940"), new Prova(3), (short) 167));
			itens.add(new Item("1VLiSqYHbzmIpUJxTZot8UOtruV_XYZK6", Resposta.B, new Habilidade((byte) 6), new BigDecimal("4.06335"), new BigDecimal("2.18033"), new BigDecimal("0.21610"), new Prova(3), (short) 168));
			itens.add(new Item("1pWC3myH4SS-131KbUg4gkYmCdpT1I8Rl", Resposta.E, new Habilidade((byte) 2), new BigDecimal("1.57033"), new BigDecimal("2.17738"), new BigDecimal("0.11432"), new Prova(3), (short) 170));
			itens.add(new Item("13ghVx_IqBCHwj4VEQ4qj3v4HVkdadc2v", Resposta.C, new Habilidade((byte) 3), new BigDecimal("1.89497"), new BigDecimal("1.65188"), new BigDecimal("0.27993"), new Prova(3), (short) 176)); //acaba 2020
			itens.add(new Item("16HMTT-G6acfdOUA7JK-Awmc7hhMtdICw", Resposta.D, new Habilidade((byte) 1), new BigDecimal("1.68298"), new BigDecimal("1.21252"), new BigDecimal("0.14575"), new Prova(2), (short) 136));
			itens.add(new Item("1-OdItTO7uL90p2Xig0uRc4a04lFf1JH2", Resposta.D, new Habilidade((byte) 1), new BigDecimal("2.48037"), new BigDecimal("1.40250"), new BigDecimal("0.20245"), new Prova(2), (short) 137));
			itens.add(new Item("1OcD9U4vP2Fduzp1S59Lvk8JhqUOjXbv9", Resposta.C, new Habilidade((byte) 3), new BigDecimal("3.29525"), new BigDecimal("1.21452"), new BigDecimal("0.20483"), new Prova(2), (short) 138));
			itens.add(new Item("1N6NXyOVSee02EzqYsobwQeIAMXMKR9i6", Resposta.A, new Habilidade((byte) 2), new BigDecimal("2.75345"), new BigDecimal("1.87459"), new BigDecimal("0.13839"), new Prova(2), (short) 139));
			itens.add(new Item("1ffFDhJ7aNYn4nTYpFaEShir7_bNmD1_E", Resposta.B, new Habilidade((byte) 3), new BigDecimal("1.78096"), new BigDecimal("1.71637"), new BigDecimal("0.13024"), new Prova(2), (short) 140));
			itens.add(new Item("1If_MrimXxRfbe_aSeIVV38PYZKTxgw84", Resposta.D, new Habilidade((byte) 4), new BigDecimal("1.71655"), new BigDecimal("1.49877"), new BigDecimal("0.15898"), new Prova(2), (short) 141));
			itens.add(new Item("1Y2i4cSNvPpOdu4EFgx4h3N8U0rZ-NBZO", Resposta.C, new Habilidade((byte) 4), new BigDecimal("1.44209"), new BigDecimal("1.37865"), new BigDecimal("0.14881"), new Prova(2), (short) 142));
			itens.add(new Item("1xEwsiX7cvAATn-Auj-S2WHm74N3qwJf7", Resposta.A, new Habilidade((byte) 5), new BigDecimal("1.47905"), new BigDecimal("1.59921"), new BigDecimal("0.16153"), new Prova(2), (short) 144));
			itens.add(new Item("1SlxJvQX7R1UxzhKTdCNINIlTq8GkTKTv", Resposta.E, new Habilidade((byte) 5), new BigDecimal("1.50255"), new BigDecimal("2.16194"), new BigDecimal("0.08889"), new Prova(2), (short) 145));
			itens.add(new Item("12ldbqdlfj402rrz1uP85kDnC6PjkbYm2", Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.50712"), new BigDecimal("2.23062"), new BigDecimal("0.13965"), new Prova(2), (short) 146));
			itens.add(new Item("1N2aM5eoEv5uJWCzMPhqInVwaTtWfTuYq", Resposta.C, new Habilidade((byte) 6), new BigDecimal("1.45834"), new BigDecimal("2.40851"), new BigDecimal("0.19555"), new Prova(2), (short) 147));
			itens.add(new Item("13VAxqN_JzOjP-ge8z76AMIjARPQt_UtN", Resposta.E, new Habilidade((byte) 4), new BigDecimal("2.05592"), new BigDecimal("2.38315"), new BigDecimal("0.14790"), new Prova(2), (short) 156));
			itens.add(new Item("1rYregWKd33YU1SpPk1J6ZMPL_pVgDwaY", Resposta.E, new Habilidade((byte) 7), new BigDecimal("0.38226"), new BigDecimal("4.96788"), new BigDecimal("0.08061"), new Prova(2), (short) 162));
			itens.add(new Item("1r4ptKSpBfEbIQsSM5j9oJV--FJA_3a57", Resposta.C, new Habilidade((byte) 8), new BigDecimal("2.32415"), new BigDecimal("1.68956"), new BigDecimal("0.10646"), new Prova(2), (short) 166));
			itens.add(new Item("1W-4XxxS0u_e7k9TaT18JRZOdSUBb-rVP", Resposta.C, new Habilidade((byte) 9), new BigDecimal("1.53863"), new BigDecimal("1.95839"), new BigDecimal("0.19274"), new Prova(2), (short) 167));
			itens.add(new Item("1IjThsqiBRocTRE1LPUMYlTQo8Y7YgY9c", Resposta.C, new Habilidade((byte) 8), new BigDecimal("1.85811"), new BigDecimal("1.06450"), new BigDecimal("0.10040"), new Prova(2), (short) 168));
			itens.add(new Item("1hdeP5H6DNZOV2HNt29mhDIyTdZzy3FUu", Resposta.D, new Habilidade((byte) 9), new BigDecimal("1.67858"), new BigDecimal("0.94544"), new BigDecimal("0.07498"), new Prova(2), (short) 170));
			itens.add(new Item("1UgDsN2f5xFXlGpCy1NYs3w0zEyx8WlP6", Resposta.C, new Habilidade((byte) 10), new BigDecimal("1.41349"), new BigDecimal("2.47483"), new BigDecimal("0.26937"), new Prova(2), (short) 172));
			itens.add(new Item("1W8UiPjnmNvSfTIXKBAnq5jXJZzxlvUjV", Resposta.E, new Habilidade((byte) 10), new BigDecimal("3.23662"), new BigDecimal("1.93237"), new BigDecimal("0.16879"), new Prova(2), (short) 173));
			itens.add(new Item("1Gzzulg5kP-BVIYcJAbdCY2u5ydKnNdqG", Resposta.E, new Habilidade((byte) 2), new BigDecimal("1.38496"), new BigDecimal("1.73939"), new BigDecimal("0.14078"), new Prova(2), (short) 179)); //acaba 2021
			itens.add(new Item("11Ib3jbYfIoLNWU6DMeY2G8DhyLkz64Xk", Resposta.A, new Habilidade((byte) 4), new BigDecimal("2.57245"), new BigDecimal("1.58603"), new BigDecimal("0.10176"), new Prova(1), (short) 140));
			itens.add(new Item("1z50oMhEQg5uffXKVP-HvGjChs6UTJFZY", Resposta.B, new Habilidade((byte) 9), new BigDecimal("2.18973"), new BigDecimal("1.32978"), new BigDecimal("0.04601"), new Prova(1), (short) 143));
			itens.add(new Item("14aIyVlHvOD-CTaPtBYajZCjITJiUT3Yi", Resposta.E, new Habilidade((byte) 1), new BigDecimal("1.42701"), new BigDecimal("-0.02398"), new BigDecimal("0.11013"), new Prova(1), (short) 144));
			itens.add(new Item("1NYs9UiV6czZNoeUheCFrBmOYjCSza-ja", Resposta.A, new Habilidade((byte) 9), new BigDecimal("1.32325"), new BigDecimal("0.64802"), new BigDecimal("0.18728"), new Prova(1), (short) 146));
			itens.add(new Item("1MtF7wr0KcTSJfDebnF8ZqtshupqUwTX6", Resposta.C, new Habilidade((byte) 3), new BigDecimal("2.19381"), new BigDecimal("1.56693"), new BigDecimal("0.13020"), new Prova(1), (short) 149));
			itens.add(new Item("1i3gRyN-iLLWqUvx7v7sHsCPmjS0V00mo", Resposta.B, new Habilidade((byte) 2), new BigDecimal("0.92146"), new BigDecimal("2.16924"), new BigDecimal("0.15718"), new Prova(1), (short) 150));
			itens.add(new Item("1tefLaVVzYvEsqpIDSFQtsU4xqPhBioz8", Resposta.E, new Habilidade((byte) 8), new BigDecimal("2.33252"), new BigDecimal("2.40899"), new BigDecimal("0.14217"), new Prova(1), (short) 151));
			itens.add(new Item("1GbdD8tggwIHrmBAt7meHUggrvLMkI6Mq", Resposta.C, new Habilidade((byte) 10), new BigDecimal("0.24441"), new BigDecimal("4.65334"), new BigDecimal("0.03228"), new Prova(1), (short) 152));
			itens.add(new Item("1xwGICenHlFfqJHtK8S5JQwSGUit-Y330", Resposta.E, new Habilidade((byte) 7), new BigDecimal("2.27997"), new BigDecimal("2.41531"), new BigDecimal("0.11329"), new Prova(1), (short) 155));
			itens.add(new Item("1H7AwXhbIZEDhi0vTlGJ0Ex2UtGuDwqYr", Resposta.D, new Habilidade((byte) 5), new BigDecimal("0.90320"), new BigDecimal("2.45135"), new BigDecimal("0.16170"), new Prova(1), (short) 158));
			itens.add(new Item("1LkPzanR4pKmlyl02KuAvFkaaYxY2bAFV", Resposta.C, new Habilidade((byte) 1), new BigDecimal("1.18017"), new BigDecimal("1.92189"), new BigDecimal("0.16856"), new Prova(1), (short) 159));
			itens.add(new Item("1TFBGj3elTUkoTfwlD5OXteUJPp7VT_ZR", Resposta.B, new Habilidade((byte) 3), new BigDecimal("1.57712"), new BigDecimal("3.30111"), new BigDecimal("0.16855"), new Prova(1), (short) 161));
//			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 10), null, null, null, new Prova(1), (short) 162));
			itens.add(new Item("1yojP8gmX6gSYnzf1cqCWhpXBIrk7p0Eg", Resposta.C, new Habilidade((byte) 5), new BigDecimal("0.79395"), new BigDecimal("2.40685"), new BigDecimal("0.11290"), new Prova(1), (short) 163));
			itens.add(new Item("1LM0JWp6RLn5G2hGCnaEYAfcLBhXXJCuD", Resposta.D, new Habilidade((byte) 8), new BigDecimal("2.81078"), new BigDecimal("0.63977"), new BigDecimal("0.16335"), new Prova(1), (short) 168));
			itens.add(new Item("1oGtHX_c7wFQFJX8QuGrsMlAb5bag1_Ye", Resposta.D, new Habilidade((byte) 6), new BigDecimal("2.93886"), new BigDecimal("2.57768"), new BigDecimal("0.12028"), new Prova(1), (short) 169));
			itens.add(new Item("15rTgb5yyjZRG8p0qhAKtTYLP3fIxDuib", Resposta.B, new Habilidade((byte) 2), new BigDecimal("2.17147"), new BigDecimal("2.54230"), new BigDecimal("0.18410"), new Prova(1), (short) 177)); //acaba 2022
			
			itemRepository.saveAll(itens);
		}
	}
	
}
