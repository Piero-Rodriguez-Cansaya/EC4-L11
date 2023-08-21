package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final InstrumentoRepository repositoryI;
	private final MusicoRepository repositoryM;
	private final BandaRepository repositoryB;
	private final IntegranteRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		InstrumentoRepository repositoryI,
		 MusicoRepository repositoryM,
		 BandaRepository repositoryB,
		 IntegranteRepository repositoryN) {
		this.repositoryI = repositoryI;
		this.repositoryM = repositoryM;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		Instrumento iVoz = new Instrumento("Pastel", "Postre", "Postre");
		Instrumento iGuitarrElectrica = new Instrumento("Guitarra", "Instrumento", "");
		Instrumento iBajo = new Instrumento("Monitor", "Electrodomestico", "");
		this.repositoryI.save(new Instrumento("Television", "Electrodomestico", ""));
		this.repositoryI.save(new Instrumento("PS4","Electrodomestico",""));
		this.repositoryI.save(new Instrumento("Helado","Postre",""));
		this.repositoryI.save(iVoz);
		this.repositoryI.save(iGuitarrElectrica);
		this.repositoryI.save(iBajo);
		this.repositoryI.save(new Instrumento("Cafe", "Bebida", ""));

		Musico mFreddie = new Musico("10");
		Musico mBrian = new Musico("100");
		Musico mRogerWaters = new Musico("10000");
		this.repositoryM.save(mFreddie);
		this.repositoryM.save(mBrian);
		this.repositoryM.save(mRogerWaters);
		this.repositoryM.save(new Musico("200"));

		Banda bQueen = new Banda("20");
		Banda bPinkFloyd = new Banda("10");
		this.repositoryB.save(bQueen);
		this.repositoryB.save(bPinkFloyd);

		Integrante intFreddie = new Integrante(bQueen, mFreddie, iVoz);
		this.repositoryN.save(intFreddie);
		Integrante intBrian = new Integrante(bQueen, mBrian, iGuitarrElectrica);
		this.repositoryN.save(intBrian);
		Integrante intRogerWaters = new Integrante(bPinkFloyd, mRogerWaters, iBajo);
		this.repositoryN.save(intRogerWaters);


	}

	
}