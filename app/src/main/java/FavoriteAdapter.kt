import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_streetartcei.R
import com.example.projeto_streetartcei.modelos.Graffiti

class FavoriteAdapter(private val graffitiList: List<Graffiti>) :
    RecyclerView.Adapter<FavoriteAdapter.FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite, parent, false)
        return FavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val currentGraffiti = graffitiList[position]
        holder.imageViewGraffiti.setImageResource(currentGraffiti.imageResource)
        holder.textViewGraffitiTitle.text = currentGraffiti.title
        holder.textViewGraffitiArtist.text = currentGraffiti.artist
        holder.textViewGraffitiDescription.text = currentGraffiti.description
    }

    override fun getItemCount(): Int {
        return graffitiList.size
    }

    inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewGraffiti: ImageView = itemView.findViewById(R.id.imageViewGraffiti)
        val textViewGraffitiTitle: TextView = itemView.findViewById(R.id.textViewGraffitiTitle)
        val textViewGraffitiArtist: TextView = itemView.findViewById(R.id.textViewGraffitiArtist)
        val textViewGraffitiDescription: TextView = itemView.findViewById(R.id.textViewGraffitiDescription)
    }
}
