package sgi.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="curso")
public class Curso {
	
	private Integer idCurso;
	private String codigoCurso;
	private Idioma idIdioma;
	private TipoCurso idTipoCurso;
	private Modalidad idModalidad;
	private Nivel idNivel;

	
	@JsonIgnore
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Curso(Integer idCurso) {
		super();
		this.idCurso = idCurso;
	}


	public Curso(String codigoCurso, Idioma idIdioma, TipoCurso idTipoCurso, Modalidad idModalidad, Nivel idNivel) {
		super();
		this.codigoCurso = codigoCurso;
		this.idIdioma = idIdioma;
		this.idTipoCurso = idTipoCurso;
		this.idModalidad = idModalidad;
		this.idNivel = idNivel;
	}


	@Id
	@Column(name = "idCurso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdCurso() {
		return idCurso;
	}


	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	@Column(name = "codigoCurso" )
	public String getCodigoCurso() {
		return codigoCurso;
	}


	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	@OneToOne(targetEntity = Idioma.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idIdioma", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Idioma getIdIdioma() {
		return idIdioma;
	}


	public void setIdIdioma(Idioma idIdioma) {
		this.idIdioma = idIdioma;
	}

	@OneToOne(targetEntity = TipoCurso.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idTipoCurso", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public TipoCurso getIdTipoCurso() {
		return idTipoCurso;
	}


	public void setIdTipoCurso(TipoCurso idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}

	@OneToOne(targetEntity = Modalidad.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idModalidad", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Modalidad getIdModalidad() {
		return idModalidad;
	}


	public void setIdModalidad(Modalidad idModalidad) {
		this.idModalidad = idModalidad;
	}

	@OneToOne(targetEntity = Nivel.class, optional = false, fetch = FetchType.LAZY) //indica el tipo de clase
	@JoinColumn(name = "idNivel", nullable = false)//indicar la columna de la relacion de B
	@Fetch(FetchMode.JOIN)
	public Nivel getIdNivel() {
		return idNivel;
	}


	public void setIdNivel(Nivel idNivel) {
		this.idNivel = idNivel;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigoCurso, idCurso, idIdioma, idModalidad, idNivel, idTipoCurso);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigoCurso, other.codigoCurso) && Objects.equals(idCurso, other.idCurso)
				&& Objects.equals(idIdioma, other.idIdioma) && Objects.equals(idModalidad, other.idModalidad)
				&& Objects.equals(idNivel, other.idNivel) && Objects.equals(idTipoCurso, other.idTipoCurso);
	}
	
	
	
	
	
}
