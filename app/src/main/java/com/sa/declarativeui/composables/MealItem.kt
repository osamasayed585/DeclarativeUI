import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sa.declarativeui.composables.SpacerVertical16
import com.sa.declarativeui.ui.theme.Rubik
import com.sa.declarativeui.ui.theme.cardBackgroundColor
import com.sa.declarativeui.viewModel.state.MealUiState

@Composable
fun MealItem(
    meal: MealUiState,
    onItemClick: (MealUiState) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .clickable { onItemClick(meal) },

        shape = RoundedCornerShape(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter(model = meal.imageUtl),
                contentDescription = "",
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Crop
            )
            SpacerVertical16()
            Text(
                text = meal.name,
                fontFamily = Rubik,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(cardBackgroundColor)
                    .padding(16.dp)
            )
        }
    }
}