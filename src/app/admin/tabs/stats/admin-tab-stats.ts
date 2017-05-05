import {Component, EventEmitter, Input, Output} from "@angular/core";
import {AdminTabStatsModel} from "./admin-tab-stats.model";

@Component({
  moduleId: module.id,
  selector: 'freebird-admin-tab-stats',
  templateUrl: 'admin-tab-stats.component.html'
})
export class AdminTabStatsComponent {

  @Input()
  model: AdminTabStatsModel;

  @Output()
  onScanAllClickedEvent = new EventEmitter<boolean>();

  @Output()
  onRefreshClickedEvent = new EventEmitter<boolean>();

  onScanAllClicked(checked: boolean) {
    this.onScanAllClickedEvent.emit(checked);
  }

  onRefreshClicked() {
    this.onRefreshClickedEvent.emit();
  }
}
