package graphics.scenery.dimensionalreduction

import ch.systemsx.cisd.hdf5.*
import java.lang.Object
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

data class ObsCompoundType(
    val index: String,
    val n_genes_by_counts: Int,
    val log1p_n_genes_by_counts: Double,
    val total_counts: Float,
    val log1p_total_counts: Float,
    val pct_counts_in_top_50_genes: Double,
    val pct_counts_in_top_100_genes: Double,
    val pct_counts_in_top_200_genes: Double,
    val pct_counts_in_top_500_genes: Double,
    val n_genes: Long,
    val percent_mito: Float,
    val n_counts: Float,
    val louvain:Byte,
    val leiden: Byte,
)


open class TabulaSparseReader(var pathName: String = "pbmc3k.h5ad"){

    init{
        val reader = HDF5Factory.openForReading(pathName)

        val compoundMap = mutableMapOf<String, Any>(
            "index" to String,
            "n_genes_by_counts" to Int,
            "log1p_n_genes_by_counts" to Double,
            "total_counts" to Float,
            "log1p_total_counts" to Float,
            "pct_counts_in_top_50_genes" to Double,
            "pct_counts_in_top_100_genes" to Double,
            "pct_counts_in_top_200_genes" to Double,
            "pct_counts_in_top_500_genes" to Double,
            "n_genes" to Long,
            "percent_mito" to Float,
            "n_counts" to Float,
            "louvain" to Byte,
            "leiden" to Byte,
        )

        
        //val f = reader.float32().readMDArray("/X")
        //for(i in 1..100){
        //    print(f[i])
        //}
        //println(f)

        //val n_genes = reader.float64().readMDArray("/uns/pca/variance")
        //println(n_genes)

        //val string_test = reader.string().read("/uns/louvain_categories")
        //println(string_test)

        //val obs = reader.`object`().getAllGroupMembers("/uns")
        //val obs = reader.`object`().getObjectType("/uns/pca/variance")
        //val obs = reader.getDataSetInformation("/obs")
        //val obs2 = reader.getLinkInformation("/obs")

        //val c_obs = reader.compound().getNamedType("/X", ObsCompoundType)
        //val c_obs = reader.getCompoundDataSetInformation("/obs")
        //for(i in 0..c_obs.size) {
        //    println(c_obs[i])
        //}

        //val c_type = reader.getCompoundType("/obs", ObsCompoundType.class, c_obs)
        //(MutableMap<out String!, out Any!>..Map<out String!, Any!>?)

        //val cType = reader.compound().getType("/obs", ObsCompoundType.class<H5T_COMPOUND>)

        //println(obs2)

        //val as_byte = reader.readAsByteArray("/obs")
        //println(as_byte[15])

        //val as_compound = reader.compound().read("/obs", )



        println("hello world init")
        reader.close()
    }

}


fun main() {
    TabulaSparseReader("pbmc3k.h5ad")
    println("hello world main")
}

