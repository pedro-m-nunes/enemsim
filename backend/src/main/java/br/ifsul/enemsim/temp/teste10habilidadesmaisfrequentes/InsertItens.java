package br.ifsul.enemsim.temp.teste10habilidadesmaisfrequentes;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import br.ifsul.enemsim.entidades.Habilidade;
import br.ifsul.enemsim.entidades.Item;
import br.ifsul.enemsim.entidades.Prova;
import br.ifsul.enemsim.entidades.auxiliar.Resposta;
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
			// salvar somente o "id" do link?
			
			itens.add(new Item("https://drive.google.com/file/d/1B8nxgFiM_p15LadNKj1Brw-1m2TYvD0a/preview", Resposta.A, new Habilidade((byte) 6), new BigDecimal("2.15675"), new BigDecimal("0.94349"), new BigDecimal("0.17590"), new Prova(7), (short) 143));
			itens.add(new Item("https://drive.google.com/file/d/1WIcRrcIXKyZo7lZzZApeMoQFmfE2F0WS/preview", Resposta.A, new Habilidade((byte) 7), new BigDecimal("3.46951"), new BigDecimal("4.11405"), new BigDecimal("0.12580"), new Prova(7), (short) 145));
			itens.add(new Item("https://drive.google.com/file/d/15Ah9-EPtcPmJ6YwqnZoqdYfVLWZiLLkn/preview", Resposta.E, new Habilidade((byte) 5), new BigDecimal("1.03003"), new BigDecimal("2.09956"), new BigDecimal("0.17070"), new Prova(7), (short) 148));
			itens.add(new Item("https://drive.google.com/file/d/1LfxUF60W2UZxGMlFNS1rYkydbW7K4-ZT/preview", Resposta.D, new Habilidade((byte) 10), new BigDecimal("3.41203"), new BigDecimal("3.87930"), new BigDecimal("0.05419"), new Prova(7), (short) 149));
			itens.add(new Item("https://drive.google.com/file/d/1pXJJtavxGzdKmGaaJzm3mu9joAq1LtRn/preview", Resposta.C, new Habilidade((byte) 8), new BigDecimal("2.15388"), new BigDecimal("2.04178"), new BigDecimal("0.28781"), new Prova(7), (short) 150));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 6), new BigDecimal("1.42194"), new BigDecimal("1.80813"), new BigDecimal("0.27450"), new Prova(7), (short) 151));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 3), new BigDecimal("0.87277"), new BigDecimal("2.82511"), new BigDecimal("0.21108"), new Prova(7), (short) 152));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 3), new BigDecimal("1.16472"), new BigDecimal("3.02993"), new BigDecimal("0.10360"), new Prova(7), (short) 155));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 5), new BigDecimal("1.98262"), new BigDecimal("2.01086"), new BigDecimal("0.12481"), new Prova(7), (short) 156));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 4), new BigDecimal("1.74587"), new BigDecimal("2.17499"), new BigDecimal("0.30318"), new Prova(7), (short) 162));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 7), new BigDecimal("3.41610"), new BigDecimal("4.31587"), new BigDecimal("0.12228"), new Prova(7), (short) 165));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 1), new BigDecimal("1.76491"), new BigDecimal("1.26471"), new BigDecimal("0.11821"), new Prova(7), (short) 169));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 2), new BigDecimal("1.70587"), new BigDecimal("3.19644"), new BigDecimal("0.20825"), new Prova(7), (short) 170));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 1), new BigDecimal("1.54884"), new BigDecimal("0.96427"), new BigDecimal("0.24491"), new Prova(7), (short) 177));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 9), new BigDecimal("1.49174"), new BigDecimal("-0.42299"), new BigDecimal("0.19323"), new Prova(7), (short) 178));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 10), new BigDecimal("1.06024"), new BigDecimal("-0.23853"), new BigDecimal("0.20527"), new Prova(7), (short) 180));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 9), new BigDecimal("1.64539"), new BigDecimal("1.89258"), new BigDecimal("0.19287"), new Prova(6), (short) 136));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 8), new BigDecimal("1.82869"), new BigDecimal("1.82931"), new BigDecimal("0.18734"), new Prova(6), (short) 138));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 9), new BigDecimal("1.89960"), new BigDecimal("2.10590"), new BigDecimal("0.10770"), new Prova(6), (short) 139));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 7), new BigDecimal("0.86661"), new BigDecimal("3.92011"), new BigDecimal("0.18600"), new Prova(6), (short) 145));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.98636"), new BigDecimal("2.03775"), new BigDecimal("0.14588"), new Prova(6), (short) 146));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 10), new BigDecimal("1.63497"), new BigDecimal("3.74711"), new BigDecimal("0.20983"), new Prova(6), (short) 147));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 10), new BigDecimal("1.11894"), new BigDecimal("0.27904"), new BigDecimal("0.19659"), new Prova(6), (short) 148));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 8), new BigDecimal("1.60951"), new BigDecimal("3.12558"), new BigDecimal("0.13029"), new Prova(6), (short) 151));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 7), new BigDecimal("2.10247"), new BigDecimal("2.63616"), new BigDecimal("0.27970"), new Prova(6), (short) 152));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 2), new BigDecimal("2.05535"), new BigDecimal("2.59645"), new BigDecimal("0.17208"), new Prova(6), (short) 153));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 2), new BigDecimal("1.35187"), new BigDecimal("2.42336"), new BigDecimal("0.15877"), new Prova(6), (short) 157));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 1), new BigDecimal("1.50889"), new BigDecimal("1.52149"), new BigDecimal("0.16712"), new Prova(6), (short) 158));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 5), new BigDecimal("2.94115"), new BigDecimal("4.08667"), new BigDecimal("0.13540"), new Prova(6), (short) 162));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 4), new BigDecimal("1.75245"), new BigDecimal("1.16274"), new BigDecimal("0.08471"), new Prova(6), (short) 164));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 6), new BigDecimal("1.07664"), new BigDecimal("1.11684"), new BigDecimal("0.13937"), new Prova(6), (short) 165));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 3), new BigDecimal("1.46119"), new BigDecimal("2.45335"), new BigDecimal("0.12054"), new Prova(6), (short) 168));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 4), new BigDecimal("1.82503"), new BigDecimal("1.84464"), new BigDecimal("0.15051"), new Prova(6), (short) 169));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 3), new BigDecimal("1.15634"), new BigDecimal("2.81506"), new BigDecimal("0.10382"), new Prova(6), (short) 170));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 4), new BigDecimal("3.05583"), new BigDecimal("1.34943"), new BigDecimal("0.10809"), new Prova(5), (short) 137));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 5), new BigDecimal("2.66415"), new BigDecimal("1.64983"), new BigDecimal("0.09545"), new Prova(5), (short) 139));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 2), new BigDecimal("2.43503"), new BigDecimal("1.63320"), new BigDecimal("0.12168"), new Prova(5), (short) 149));
//			itens.add(new Item(null, null, new Habilidade((byte) 4), null, null, null, new Prova(5), (short) 150));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 8), new BigDecimal("1.25148"), new BigDecimal("0.88381"), new BigDecimal("0.13308"), new Prova(5), (short) 156));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 9), new BigDecimal("1.47034"), new BigDecimal("3.31311"), new BigDecimal("0.14240"), new Prova(5), (short) 157));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("2.55414"), new BigDecimal("2.66770"), new BigDecimal("0.22815"), new Prova(5), (short) 159));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("1.15923"), new BigDecimal("1.57022"), new BigDecimal("0.17437"), new Prova(5), (short) 160));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 2), new BigDecimal("1.78838"), new BigDecimal("2.97454"), new BigDecimal("0.24777"), new Prova(5), (short) 161));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 10), new BigDecimal("3.06510"), new BigDecimal("1.86549"), new BigDecimal("0.14637"), new Prova(5), (short) 162));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 10), new BigDecimal("2.92985"), new BigDecimal("1.87774"), new BigDecimal("0.13712"), new Prova(5), (short) 163));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 1), new BigDecimal("1.75065"), new BigDecimal("2.41940"), new BigDecimal("0.14805"), new Prova(5), (short) 164));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 8), new BigDecimal("3.16831"), new BigDecimal("1.44943"), new BigDecimal("0.19086"), new Prova(5), (short) 167));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 7), new BigDecimal("1.92900"), new BigDecimal("3.00800"), new BigDecimal("0.18500"), new Prova(5), (short) 168));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 6), new BigDecimal("2.10243"), new BigDecimal("1.89084"), new BigDecimal("0.11933"), new Prova(5), (short) 169));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 7), new BigDecimal("2.60715"), new BigDecimal("3.02371"), new BigDecimal("0.30706"), new Prova(5), (short) 172));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 9), new BigDecimal("1.88752"), new BigDecimal("2.03259"), new BigDecimal("0.09961"), new Prova(5), (short) 173));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.06810"), new BigDecimal("2.89341"), new BigDecimal("0.16386"), new Prova(5), (short) 179));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 2), new BigDecimal("1.25552"), new BigDecimal("1.93449"), new BigDecimal("0.06675"), new Prova(4), (short) 137));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 8), new BigDecimal("1.51000"), new BigDecimal("3.00300"), new BigDecimal("0.14700"), new Prova(4), (short) 138));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 7), new BigDecimal("2.28700"), new BigDecimal("2.21700"), new BigDecimal("0.08500"), new Prova(4), (short) 140));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 4), new BigDecimal("1.78432"), new BigDecimal("1.16670"), new BigDecimal("0.04550"), new Prova(4), (short) 143));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 1), new BigDecimal("1.86876"), new BigDecimal("0.42930"), new BigDecimal("0.12552"), new Prova(4), (short) 144));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 1), new BigDecimal("1.12267"), new BigDecimal("0.37213"), new BigDecimal("0.26876"), new Prova(4), (short) 148));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 9), new BigDecimal("2.72919"), new BigDecimal("1.92868"), new BigDecimal("0.23186"), new Prova(4), (short) 150));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 3), new BigDecimal("3.17618"), new BigDecimal("2.35696"), new BigDecimal("0.27294"), new Prova(4), (short) 157));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 7), new BigDecimal("1.72060"), new BigDecimal("2.05336"), new BigDecimal("0.18597"), new Prova(4), (short) 158));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 2), new BigDecimal("3.93635"), new BigDecimal("3.78057"), new BigDecimal("0.19828"), new Prova(4), (short) 159));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("2.45518"), new BigDecimal("2.61221"), new BigDecimal("0.15911"), new Prova(4), (short) 160));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 5), new BigDecimal("3.76775"), new BigDecimal("2.42062"), new BigDecimal("0.20831"), new Prova(4), (short) 161));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 10), new BigDecimal("2.17954"), new BigDecimal("1.95289"), new BigDecimal("0.13818"), new Prova(4), (short) 165));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 4), new BigDecimal("3.41848"), new BigDecimal("1.95818"), new BigDecimal("0.16938"), new Prova(4), (short) 168));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.52296"), new BigDecimal("2.72201"), new BigDecimal("0.36496"), new Prova(4), (short) 171));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 8), new BigDecimal("4.12689"), new BigDecimal("2.88940"), new BigDecimal("0.12635"), new Prova(4), (short) 175));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 10), new BigDecimal("2.59370"), new BigDecimal("1.91179"), new BigDecimal("0.07742"), new Prova(4), (short) 176));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 9), new BigDecimal("5.31206"), new BigDecimal("3.34343"), new BigDecimal("0.16052"), new Prova(4), (short) 177));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 6), new BigDecimal("2.24304"), new BigDecimal("2.30004"), new BigDecimal("0.20665"), new Prova(4), (short) 178));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 7), new BigDecimal("2.58330"), new BigDecimal("1.63345"), new BigDecimal("0.16356"), new Prova(4), (short) 180));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 5), new BigDecimal("1.20090"), new BigDecimal("0.84968"), new BigDecimal("0.16359"), new Prova(3), (short) 137));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 7), new BigDecimal("3.29625"), new BigDecimal("2.86173"), new BigDecimal("0.25529"), new Prova(3), (short) 139));
//			itens.add(new Item(null, null, new Habilidade((byte) 10), null, null, null, new Prova(3), (short) 141));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("1.78193"), new BigDecimal("3.29884"), new BigDecimal("0.18914"), new Prova(3), (short) 142));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 4), new BigDecimal("0.96583"), new BigDecimal("2.50648"), new BigDecimal("0.20490"), new Prova(3), (short) 143));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 1), new BigDecimal("2.18282"), new BigDecimal("2.31084"), new BigDecimal("0.14885"), new Prova(3), (short) 147));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 1), new BigDecimal("1.58670"), new BigDecimal("-0.08552"), new BigDecimal("0.20086"), new Prova(3), (short) 149));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 9), new BigDecimal("2.75624"), new BigDecimal("0.62447"), new BigDecimal("0.09203"), new Prova(3), (short) 151));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 3), new BigDecimal("1.73821"), new BigDecimal("2.68030"), new BigDecimal("0.13986"), new Prova(3), (short) 153));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 8), new BigDecimal("2.96092"), new BigDecimal("0.89580"), new BigDecimal("0.18532"), new Prova(3), (short) 155));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 5), new BigDecimal("2.99017"), new BigDecimal("1.89021"), new BigDecimal("0.15884"), new Prova(3), (short) 158));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 10), new BigDecimal("2.09221"), new BigDecimal("0.99371"), new BigDecimal("0.13290"), new Prova(3), (short) 163));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 2), new BigDecimal("2.59667"), new BigDecimal("1.34028"), new BigDecimal("0.15449"), new Prova(3), (short) 166));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 9), new BigDecimal("2.04724"), new BigDecimal("1.08171"), new BigDecimal("0.17940"), new Prova(3), (short) 167));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 6), new BigDecimal("4.06335"), new BigDecimal("2.18033"), new BigDecimal("0.21610"), new Prova(3), (short) 168));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 2), new BigDecimal("1.57033"), new BigDecimal("2.17738"), new BigDecimal("0.11432"), new Prova(3), (short) 170));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("1.89497"), new BigDecimal("1.65188"), new BigDecimal("0.27993"), new Prova(3), (short) 176));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 1), new BigDecimal("1.68298"), new BigDecimal("1.21252"), new BigDecimal("0.14575"), new Prova(2), (short) 136));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 1), new BigDecimal("2.48037"), new BigDecimal("1.40250"), new BigDecimal("0.20245"), new Prova(2), (short) 137));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("3.29525"), new BigDecimal("1.21452"), new BigDecimal("0.20483"), new Prova(2), (short) 138));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 2), new BigDecimal("2.75345"), new BigDecimal("1.87459"), new BigDecimal("0.13839"), new Prova(2), (short) 139));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 3), new BigDecimal("1.78096"), new BigDecimal("1.71637"), new BigDecimal("0.13024"), new Prova(2), (short) 140));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 4), new BigDecimal("1.71655"), new BigDecimal("1.49877"), new BigDecimal("0.15898"), new Prova(2), (short) 141));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 4), new BigDecimal("1.44209"), new BigDecimal("1.37865"), new BigDecimal("0.14881"), new Prova(2), (short) 142));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 5), new BigDecimal("1.47905"), new BigDecimal("1.59921"), new BigDecimal("0.16153"), new Prova(2), (short) 144));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 5), new BigDecimal("1.50255"), new BigDecimal("2.16194"), new BigDecimal("0.08889"), new Prova(2), (short) 145));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 6), new BigDecimal("1.50712"), new BigDecimal("2.23062"), new BigDecimal("0.13965"), new Prova(2), (short) 146));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 6), new BigDecimal("1.45834"), new BigDecimal("2.40851"), new BigDecimal("0.19555"), new Prova(2), (short) 147));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 4), new BigDecimal("2.05592"), new BigDecimal("2.38315"), new BigDecimal("0.14790"), new Prova(2), (short) 156));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 7), new BigDecimal("0.38226"), new BigDecimal("4.96788"), new BigDecimal("0.08061"), new Prova(2), (short) 162));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 8), new BigDecimal("2.32415"), new BigDecimal("1.68956"), new BigDecimal("0.10646"), new Prova(2), (short) 166));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 9), new BigDecimal("1.53863"), new BigDecimal("1.95839"), new BigDecimal("0.19274"), new Prova(2), (short) 167));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 8), new BigDecimal("1.85811"), new BigDecimal("1.06450"), new BigDecimal("0.10040"), new Prova(2), (short) 168));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 9), new BigDecimal("1.67858"), new BigDecimal("0.94544"), new BigDecimal("0.07498"), new Prova(2), (short) 170));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 10), new BigDecimal("1.41349"), new BigDecimal("2.47483"), new BigDecimal("0.26937"), new Prova(2), (short) 172));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 10), new BigDecimal("3.23662"), new BigDecimal("1.93237"), new BigDecimal("0.16879"), new Prova(2), (short) 173));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 2), new BigDecimal("1.38496"), new BigDecimal("1.73939"), new BigDecimal("0.14078"), new Prova(2), (short) 179));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 4), new BigDecimal("2.57245"), new BigDecimal("1.58603"), new BigDecimal("0.10176"), new Prova(1), (short) 140));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 9), new BigDecimal("2.18973"), new BigDecimal("1.32978"), new BigDecimal("0.04601"), new Prova(1), (short) 143));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 1), new BigDecimal("1.42701"), new BigDecimal("-0.02398"), new BigDecimal("0.11013"), new Prova(1), (short) 144));
			itens.add(new Item(null, Resposta.A, new Habilidade((byte) 9), new BigDecimal("1.32325"), new BigDecimal("0.64802"), new BigDecimal("0.18728"), new Prova(1), (short) 146));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 3), new BigDecimal("2.19381"), new BigDecimal("1.56693"), new BigDecimal("0.13020"), new Prova(1), (short) 149));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 2), new BigDecimal("0.92146"), new BigDecimal("2.16924"), new BigDecimal("0.15718"), new Prova(1), (short) 150));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 8), new BigDecimal("2.33252"), new BigDecimal("2.40899"), new BigDecimal("0.14217"), new Prova(1), (short) 151));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 10), new BigDecimal("0.24441"), new BigDecimal("4.65334"), new BigDecimal("0.03228"), new Prova(1), (short) 152));
			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 7), new BigDecimal("2.27997"), new BigDecimal("2.41531"), new BigDecimal("0.11329"), new Prova(1), (short) 155));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 5), new BigDecimal("0.90320"), new BigDecimal("2.45135"), new BigDecimal("0.16170"), new Prova(1), (short) 158));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 1), new BigDecimal("1.18017"), new BigDecimal("1.92189"), new BigDecimal("0.16856"), new Prova(1), (short) 159));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 3), new BigDecimal("1.57712"), new BigDecimal("3.30111"), new BigDecimal("0.16855"), new Prova(1), (short) 161));
//			itens.add(new Item(null, Resposta.E, new Habilidade((byte) 10), null, null, null, new Prova(1), (short) 162));
			itens.add(new Item(null, Resposta.C, new Habilidade((byte) 5), new BigDecimal("0.79395"), new BigDecimal("2.40685"), new BigDecimal("0.11290"), new Prova(1), (short) 163));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 8), new BigDecimal("2.81078"), new BigDecimal("0.63977"), new BigDecimal("0.16335"), new Prova(1), (short) 168));
			itens.add(new Item(null, Resposta.D, new Habilidade((byte) 6), new BigDecimal("2.93886"), new BigDecimal("2.57768"), new BigDecimal("0.12028"), new Prova(1), (short) 169));
			itens.add(new Item(null, Resposta.B, new Habilidade((byte) 2), new BigDecimal("2.17147"), new BigDecimal("2.54230"), new BigDecimal("0.18410"), new Prova(1), (short) 177));
			
			itemRepository.saveAll(itens);
		}
	}
	
}
